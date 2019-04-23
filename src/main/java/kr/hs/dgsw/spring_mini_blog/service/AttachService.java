package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.Attach;
import kr.hs.dgsw.spring_mini_blog.protocol.ResponseFormat;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.UUID;

public interface AttachService {
    ResponseEntity<Resource> get(String id) throws MalformedURLException;
    ResponseFormat create(MultipartFile file);
    ResponseFormat remove(UUID id);
}
