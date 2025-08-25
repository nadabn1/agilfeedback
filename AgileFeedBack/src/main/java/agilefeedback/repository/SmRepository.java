package agilefeedback.repository;

import agilefeedback.model.Sm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SmRepository extends JpaRepository<Sm, Long> {
    Optional<Sm> findByEmail(String email);
}
