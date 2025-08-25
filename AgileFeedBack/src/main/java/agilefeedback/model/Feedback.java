package agilefeedback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name = "feedbacks")
public class Feedback {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String type;

    @Column(columnDefinition = "TEXT")
    private String commentaire;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "client_full_name")
    private String clientFullName;
}
