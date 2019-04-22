package kr.hs.dgsw.spring_mini_blog.service;

import kr.hs.dgsw.spring_mini_blog.domain.Attach;
import kr.hs.dgsw.spring_mini_blog.repository.AttachRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttachServiceImpl implements AttachService {
    private final AttachRepository attachRepository;

    @Autowired
    public AttachServiceImpl(AttachRepository attachRepository) {
        this.attachRepository = attachRepository;
    }

    @Override
    public ResponseEntity<Resource> get(String id) throws MalformedURLException {
        Optional<Attach> target = attachRepository.findById(UUID.fromString(id));
        if (!target.isPresent()) {
            return null;
        }

        Attach targetFile = target.get();

        File file = new File(System.getProperty("user.dir") + targetFile.getRelativePath());
        Path path = Paths.get(file.getPath());

        Resource body = new UrlResource(path.toUri());

        if (!body.exists() && !body.isReadable()) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + targetFile.getOriginalName() + "\"")
                .contentLength(file.length())
                .body(body);
    }

    @Override
    public Attach create(MultipartFile file) {
        UUID uuid = UUID.randomUUID();
        String path = "\\upload\\" + uuid.toString();

        try {
            File dest = new File(System.getProperty("user.dir") + path);
            dest.getParentFile().mkdirs();
            file.transferTo(dest);
        }
        catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(AttachServiceImpl.class);
            logger.warn(e.getMessage());
            return null;
        }

        return attachRepository.save(new Attach(uuid, file.getOriginalFilename(), path));
    }

    @Override
    public Attach remove(UUID id) {
        return null;
    }
}
