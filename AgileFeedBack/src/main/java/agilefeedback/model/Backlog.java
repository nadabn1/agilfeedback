package agilefeedback.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec Projet
    @OneToOne
    @JoinColumn(name = "projet_id", nullable = false)
    private Projet projet;

    // Relation avec Sprint
    @OneToMany(mappedBy = "backlog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sprint> sprints;
}
