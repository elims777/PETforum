package coducation.petforum.service;


import coducation.petforum.exception.CustomException;
import coducation.petforum.utils.MyUserEntity;
import coducation.petforum.utils.MyUserRepository;
import coducation.petforum.utils.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final MyUserRepository myUserRepository;

    public String registration(String login, String password, String role) {
        if (myUserRepository.findByLogin(login).isEmpty()) {
            MyUserEntity myUserEntity = new MyUserEntity();
            myUserEntity.setLogin(login);
            myUserEntity.setPassword(password);
            myUserEntity.setRole("ROLE_"+role.toUpperCase());
            myUserRepository.save(myUserEntity);
            return "Пользователь успешно зарегистрирован";
        } else {
            throw new CustomException("Такой пользователь уже существует");
        }
    }

    public String deleteUser(int userId, String userLogin) {
        MyUserEntity myUserEntity = myUserRepository.findByLogin(userLogin).orElseThrow();
        MyUserEntity deletingUser = myUserRepository.findById(userId).orElseThrow();
        if(myUserEntity.getRole().equals("ROLE_ADMIN")){
            myUserRepository.delete(deletingUser);
            return "Пользователь удален";
        } else {
            return new CustomException("У вас недостаточно прав").toString();
        }
    }

    public List<PostEntity> getPosts(String login) {
        if (myUserRepository.findByLogin(login).isPresent()) {
            MyUserEntity user = myUserRepository.findByLogin(login).get();
            return user.getPostList();
        } else {
            throw new CustomException("Пользователь не найден");
        }
    }

}
