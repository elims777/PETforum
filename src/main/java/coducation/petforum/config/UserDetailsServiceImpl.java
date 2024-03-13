package coducation.petforum.config;




import coducation.petforum.exception.CustomException;
import coducation.petforum.utils.MyUserEntity;
import coducation.petforum.utils.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MyUserRepository userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUserEntity user = userService.findByLogin(username)
                .orElseThrow(()->new CustomException("Пользователь не найден"));


        return User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(new String[]{})
                .build();

    }

}
