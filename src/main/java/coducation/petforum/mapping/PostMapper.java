package coducation.petforum.mapping;

import coducation.petforum.dto.PostDto;
import coducation.petforum.utils.PostEntity;
import org.springframework.stereotype.Service;

@Service
public class PostMapper {
    public PostDto mapToDto (PostEntity postEntity){
        return PostDto.builder()
                .id(postEntity.getId())
                .postName(postEntity.getPostName())
                .postBody(postEntity.getPostBody())
                .myUserEntity(postEntity.getMyUserEntity())
                .date(postEntity.getDate())
                .commentEntiyList(postEntity.getCommentEntiyList())
                .build();
    }

    public PostEntity mapToEntity (PostDto postDto){
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDto.getId());
        postEntity.setPostName(postDto.getPostName());
        postEntity.setPostBody(postDto.getPostBody());
        postEntity.setMyUserEntity(postDto.getMyUserEntity());
        postEntity.setDate(postDto.getDate());
        postEntity.setCommentEntiyList(postDto.getCommentEntiyList());
        return postEntity;
    }
}
