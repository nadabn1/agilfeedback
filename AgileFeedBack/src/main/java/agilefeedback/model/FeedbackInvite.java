package agilefeedback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter
@Entity
@Table(name = "feedback_invites",
        indexes = @Index(name = "idx_feedback_invites_token", columnList = "token", unique = true))
public class FeedbackInvite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String token;

    @Column(nullable = false)
    private Long clientId;

    private Long projetId;

    @Column(nullable = false)
    private String email;

    private String clientFullName;

    @Column(nullable = false)
    private Instant expiresAt;

    private Instant usedAt;
}
