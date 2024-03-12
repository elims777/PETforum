package coducation.petforum.dto;

import coducation.petforum.utils.MyUserEntity;
import coducation.petforum.utils.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class CommentDto {
    private int id;
    private String comment;
    private MyUserEntity myUserEntity;
    private LocalDate date;
    private int likeCount;
    private PostEntity postEntity;
}
