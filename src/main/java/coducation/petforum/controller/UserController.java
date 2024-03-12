package coducation.petforum.controller;

import coducation.petforum.mapping.PostMapper;
import coducation.petforum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PostMapper postMapper;


    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<String> registrationUser(@RequestParam String login,
                                                   @RequestParam String password,
                                                   @RequestParam String role){

            SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
            String encodePassword = sCryptPasswordEncoder.encode(password);
            return ResponseEntity.ok(userService.registration(login,encodePassword, role));
    }

    @GetMapping("/alluserposts")
    @ResponseBody
    public ResponseEntity<String> getAllPots(@RequestParam String login){
        return ResponseEntity.ok(userService.getPosts(login)
                        .stream()
                        .map(postMapper::mapToDto)
                        .toList().toString());
    }
    @DeleteMapping("/deleteuser")
    public String deleteUser(@RequestParam int userId, @RequestParam String userLogin){
            return userService.deleteUser(userId, userLogin);
    }

}
