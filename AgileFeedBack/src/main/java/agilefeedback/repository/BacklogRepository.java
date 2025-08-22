package agilefeedback.repository;

import agilefeedback.model.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BacklogRepository extends JpaRepository<Backlog, Long> {
    Backlog findByProjetId(Long projetId);
}
