package coducation.petforum.mapping;

import coducation.petforum.dto.CommentDto;
import coducation.petforum.utils.CommentEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper {
    public CommentDto mapToDto(CommentEntity commentEntity){
        return CommentDto.builder()
                .id(commentEntity.getId())
                .comment(commentEntity.getComment())
                .myUserEntity(commentEntity.getMyUserEntity())
                .date(commentEntity.getDate())
                .likeCount(commentEntity.getLikeCount())
                .postEntity(commentEntity.getPostEntity())
                .build();
    }

    public CommentEntity mapToEntity(CommentDto commentDto){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(commentDto.getId());
        commentEntity.setComment(commentDto.getComment());
        commentEntity.setMyUserEntity(commentDto.getMyUserEntity());
        commentEntity.setDate(commentDto.getDate());
        commentEntity.setLikeCount(commentDto.getLikeCount());
        commentEntity.setPostEntity(commentDto.getPostEntity());
        return commentEntity;
    }
}
