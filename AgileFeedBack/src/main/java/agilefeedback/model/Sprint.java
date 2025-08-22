package agilefeedback.model;


import agilefeedback.model.Enum.StatutSprint;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private StatutSprint statut;

    // Relation avec Backlog
    @ManyToOne
    @JoinColumn(name = "backlog_id", nullable = false)
    private Backlog backlog;
}
