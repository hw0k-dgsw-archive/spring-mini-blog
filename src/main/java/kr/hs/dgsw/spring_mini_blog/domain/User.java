package kr.hs.dgsw.spring_mini_blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 31)
    private String account;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public void setPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes(), 0, password.getBytes().length);

            this.password = new BigInteger(1, digest.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e) {
            Logger logger = LoggerFactory.getLogger(User.class);
            logger.warn(e.getMessage());

            this.password = null;
        }
    }

    @Column(nullable = false, length = 31)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String profilePath;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;
}
