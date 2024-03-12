package coducation.petforum.dto;

import coducation.petforum.utils.CommentEntity;
import coducation.petforum.utils.MyUserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class PostDto {
    private int id;
    private String postName;
    private String postBody;
    private MyUserEntity myUserEntity;
    private LocalDate date;
    private List<CommentEntity> commentEntiyList;
}
