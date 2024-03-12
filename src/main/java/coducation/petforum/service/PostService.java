package coducation.petforum.service;

import coducation.petforum.exception.CustomException;
import coducation.petforum.utils.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MyUserRepository myUserRepository;

    public String createPost(String name, String body, int userId){
        MyUserEntity myUserEntity = myUserRepository.findById(userId).orElseThrow();
        if(postRepository.findByPostNameAndMyUserEntity(name, myUserEntity).isEmpty()){
            PostEntity postEntity = new PostEntity();
            postEntity.setPostName(name);
            postEntity.setPostBody(body);
            postEntity.setMyUserEntity(myUserEntity);
            postEntity.setDate(LocalDate.now());
            postRepository.save(postEntity);
            return "Пост успешно добавлен";
        }else{
            throw new CustomException("Такой пост уже существует");
        }
    }

    public String setNewPost(int postId, String newBody, int userId){
        PostEntity postEntity = postRepository.findById(postId).orElseThrow();
        MyUserEntity authorEntity = postEntity.getMyUserEntity();
        MyUserEntity user = myUserRepository.findById(userId).orElseThrow();
        if(authorEntity.getLogin().equalsIgnoreCase(user.getLogin())||
                user.getRole().equals("ROLE_ADMIN")||
                user.getRole().equals("ROLE_MODERATOR")){
            postEntity.setPostBody(newBody);
            postEntity.setDate(LocalDate.now());
            postRepository.save(postEntity);
            return "Пост успешно обновлен";
        }else{
            throw new CustomException("Что-то пошло е так");
        }

    }
    public List<PostEntity> getPostOfDate(LocalDate date){
        return postRepository.findByDate(date)
                .orElseThrow(()->new CustomException("Нет постов в эту дату"));
    }


    public void deletePost(int postId,int userId){
        PostEntity postEntity = postRepository.findById(postId).get();
        MyUserEntity myUserEntity = myUserRepository.findById(userId).get();
        if(postEntity.getMyUserEntity().getLogin().equalsIgnoreCase(myUserEntity.getLogin())||
                myUserEntity.getRole().equals("ROLE_ADMIN")||
                myUserEntity.getRole().equals("ROLE_MODERATOR")){
            postRepository.delete(postEntity);
        }else{
            throw new CustomException("Пост не найден");
        }
    }
}
