package coducation.petforum.utils;



import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MyUserEntity myUserEntity;

    private LocalDate date;

    private int likeCount;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity postEntity;

    @Override
    public String toString() {
        return "CommentEntity{" +
                "comment='" + comment + '\'' +
                ", date=" + date +
                ", likeCount=" + likeCount +
                '}';
    }
}
