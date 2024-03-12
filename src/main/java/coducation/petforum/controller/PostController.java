package coducation.petforum.controller;

import coducation.petforum.service.PostService;
import coducation.petforum.service.UserService;
import coducation.petforum.utils.MyUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @PostMapping("/new-post")
    public String createPost(@RequestParam String name,
                           @RequestParam String body,
                           @RequestParam int userId){

        return postService.createPost(name,body,userId);
    }

    @PostMapping("/updatepost")
    public String updatePost(@RequestParam int postId, @RequestParam String newBody,
                                     @RequestParam int userId){
        return postService.setNewPost(postId, newBody, userId);
    }

    @DeleteMapping("/deletepost")
    public void deletePost(@RequestParam int postId,
                           @RequestParam int userId){
        postService.deletePost(postId, userId);
    }

    @GetMapping("/postofdate")
    public void postOfDate(String date){
        LocalDate localDate = LocalDate.parse(date, dtf);
        postService.getPostOfDate(localDate);
    }
}
