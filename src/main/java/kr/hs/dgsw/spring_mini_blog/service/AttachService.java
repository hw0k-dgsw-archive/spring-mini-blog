package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.Attach;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface AttachService {
    Attach get(UUID id);
    Attach create(MultipartFile file);
    Attach remove(UUID id);
}
