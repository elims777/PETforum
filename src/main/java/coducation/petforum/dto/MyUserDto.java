package coducation.petforum.dto;

import coducation.petforum.utils.PostEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class MyUserDto {
    private int id;
    private String login;
    private String password;
    private String role;
    private List<PostEntity> postList;
}
