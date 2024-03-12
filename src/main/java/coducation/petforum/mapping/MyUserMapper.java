package coducation.petforum.mapping;

import coducation.petforum.dto.MyUserDto;
import coducation.petforum.utils.MyUserEntity;
import org.springframework.stereotype.Service;

@Service
public class MyUserMapper {
    public MyUserDto mapToDto(MyUserEntity myUserEntity){
        return MyUserDto.builder()
                .id(myUserEntity.getId())
                .login(myUserEntity.getLogin())
                .password(myUserEntity.getPassword())
                .role(myUserEntity.getRole())
                .postList(myUserEntity.getPostList())
                .build();
    }

    public MyUserEntity mapToEntity (MyUserDto myUserDto){
        MyUserEntity myUserEntity = new MyUserEntity();
        myUserEntity.setId(myUserDto.getId());
        myUserEntity.setLogin(myUserDto.getLogin());
        myUserEntity.setPassword(myUserDto.getPassword());
        myUserEntity.setRole(myUserDto.getRole());
        myUserEntity.setPostList(myUserDto.getPostList());
        return myUserEntity;
    }
}
