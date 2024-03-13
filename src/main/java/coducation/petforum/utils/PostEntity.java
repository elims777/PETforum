package coducation.petforum.utils;



import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Data
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String postName;
    private String postBody;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MyUserEntity myUserEntity;
    private LocalDate date;
    @OneToMany(mappedBy = "postEntity")
    private List<CommentEntity> commentEntiyList;

    @Override
    public String toString() {
        return "PostEntity{" +
                ", postName='" + postName + '\'' +
                ", postBody='" + postBody + '\'' +
                ", myUserEntity=" + myUserEntity.getLogin() +
                ", date=" + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                '}';
    }
}
