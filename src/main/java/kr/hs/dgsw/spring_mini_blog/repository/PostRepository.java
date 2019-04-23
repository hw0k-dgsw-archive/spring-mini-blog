package kr.hs.dgsw.spring_mini_blog.repository;

import kr.hs.dgsw.spring_mini_blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findTopByUseridOrderByIdDesc(Long userid);
    Optional<Post> findTopByUseridOrderByUpdatedDesc(Long userid);
}
