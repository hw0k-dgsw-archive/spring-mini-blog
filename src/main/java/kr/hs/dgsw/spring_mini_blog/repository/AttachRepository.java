package kr.hs.dgsw.spring_mini_blog.repository;

import kr.hs.dgsw.spring_mini_blog.domain.Attach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachRepository extends JpaRepository<Attach, UUID> {

}
