package agilefeedback.repository;

import agilefeedback.model.PO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PoRepository extends JpaRepository<PO, Long> {
    Optional<PO> findByEmail(String email);
}
