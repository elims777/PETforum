package coducation.petforum.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    @Override
    Optional<PostEntity> findById(Integer integer);
    Optional<PostEntity> findByPostNameAndMyUserEntity(String name, MyUserEntity myUserEntity);

    Optional<List<PostEntity>> findByDate(LocalDate date);
}
