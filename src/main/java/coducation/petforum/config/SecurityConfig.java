package coducation.petforum.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    //    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
    @Bean
    public PasswordEncoder encoder() {
        return new SCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .httpBasic().and()
                .cors().disable()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/index.html",
                        "/registration",
                        "/alluserposts",
                        "/postofdate"
                ).permitAll()
                .anyRequest().authenticated()
//                .antMatchers(
//                        "/new-post",
//                        "/updatepost",
//                        "/deletepost",
//                        "/likecomment",
//                        "/addcomment",
//                        "/rewritecomment",
//                        "/deletecomment")
//                .access("hasAnyRole('USER', 'ADMIN', 'MODERATOR')")
//                .antMatchers("/deleteuser").access("hasRole('ADMIN')")
                .and()
                .formLogin().and().logout().permitAll();

    }
}
