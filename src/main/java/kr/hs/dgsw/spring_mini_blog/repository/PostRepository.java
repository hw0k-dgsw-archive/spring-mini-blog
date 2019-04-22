package kr.hs.dgsw.spring_mini_blog.repository;

import kr.hs.dgsw.spring_mini_blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    
}
