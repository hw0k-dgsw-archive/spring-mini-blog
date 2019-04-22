package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.Attach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class AttachServiceImpl implements AttachService {

    private final AttachService attachService;

    @Autowired
    public AttachServiceImpl(AttachService attachService) {
        this.attachService = attachService;
    }

    @Override
    public Attach get(UUID id) {
        return null;
    }

    @Override
    public Attach create(MultipartFile file) {
        return null;
    }

    @Override
    public Attach remove(UUID id) {
        return null;
    }
}
