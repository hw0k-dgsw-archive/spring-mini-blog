package kr.hs.dgsw.spring_mini_blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attach {
    @Id
    private UUID id;

    @Column(nullable = false, updatable = false)
    private String originalName;

    @Column(nullable = false, updatable = false, unique = true)
    private String relativePath;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    public Attach(UUID id, String originalName, String relativePath) {
        this.id = id;
        this.originalName = originalName;
        this.relativePath = relativePath;
    }
}
