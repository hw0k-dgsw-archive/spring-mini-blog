package kr.hs.dgsw.spring_mini_blog.controller;

import kr.hs.dgsw.spring_mini_blog.domain.Attach;
import kr.hs.dgsw.spring_mini_blog.domain.Post;
import kr.hs.dgsw.spring_mini_blog.protocol.ResponseFormat;
import kr.hs.dgsw.spring_mini_blog.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.UUID;

@RestController
public class AttachController {
    private final AttachService attachService;

    @Autowired
    public AttachController(AttachService attachService) {
        this.attachService = attachService;
    }

    @GetMapping("/attach/{id:.+}")
    public ResponseEntity<Resource> get(@PathVariable String id) throws MalformedURLException {
        return attachService.get(id);
    }

    @PostMapping("/attach")
    public ResponseFormat create(@RequestPart MultipartFile file) {
        return attachService.create(file);
    }
}
