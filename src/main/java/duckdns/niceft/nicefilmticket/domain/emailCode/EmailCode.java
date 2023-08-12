package duckdns.niceft.nicefilmticket.domain.emailCode;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_code_id")
    private Long id;

    @Email
    private String emailCode;

    private String code;

    private LocalDateTime createdAt;

    public EmailCode(String emailCode, String code) {
        this.emailCode = emailCode;
        this.code = code;
        this.createdAt = LocalDateTime.now();
    }
}
