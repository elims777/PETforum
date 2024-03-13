package coducation.petforum.utils;



import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class MyUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    @OneToMany(mappedBy = "myUserEntity")
    private List<PostEntity> postList;

    private String role;
    @OneToMany(mappedBy = "myUserEntity")
    private List<CommentEntity> commentEntityList;

    @Override
    public String toString() {
        return "MyUserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", role=" + role +
                '}';
    }
}
