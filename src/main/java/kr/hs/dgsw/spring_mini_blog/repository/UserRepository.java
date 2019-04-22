package kr.hs.dgsw.spring_mini_blog.repository;

import kr.hs.dgsw.spring_mini_blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
