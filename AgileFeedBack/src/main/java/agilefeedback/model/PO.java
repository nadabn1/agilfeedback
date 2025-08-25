package agilefeedback.model;

import agilefeedback.model.Enum.RoleType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role = RoleType.PO;
}

