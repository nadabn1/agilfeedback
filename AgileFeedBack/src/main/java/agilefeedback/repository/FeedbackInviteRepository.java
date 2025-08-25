package agilefeedback.repository;

import agilefeedback.model.FeedbackInvite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedbackInviteRepository extends JpaRepository<FeedbackInvite, Long> {
    Optional<FeedbackInvite> findByToken(String token);
    boolean existsByToken(String token);
}
