package agilefeedback.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String type;
}