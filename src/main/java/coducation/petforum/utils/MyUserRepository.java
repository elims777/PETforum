package coducation.petforum.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUserEntity, Integer> {

    Optional<MyUserEntity> findByLogin(String login);

}
