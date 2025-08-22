package agilefeedback.Dto;


import agilefeedback.model.Enum.StatutSprint;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SprintDto {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private StatutSprint statut;
    private Long backlogId;
}
