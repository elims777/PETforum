package coducation.petforum.controller;

import coducation.petforum.service.CommentService;
import coducation.petforum.utils.CommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;


    @PostMapping("/addcomment")
    public String addComment(@RequestParam int postId,@RequestParam String comment,
                             @RequestParam int userId){
       return commentService.createComment(postId, comment, userId);
    }

    @PostMapping("/rewritecomment")
    public String setNewComment(@RequestParam int commentId,@RequestParam String newComment){
        return commentService.setNewComment(commentId, newComment);
    }

    @PostMapping("/likecomment")
    public void likeComment(@RequestParam int commentId){
        commentService.setLikeToComment(commentId);
    }

    @DeleteMapping("/deletecomment")
    public String deleteComment(@RequestParam int commentId, @RequestParam int userId){
        return commentService.deleteComment(commentId, userId);
    }
}
