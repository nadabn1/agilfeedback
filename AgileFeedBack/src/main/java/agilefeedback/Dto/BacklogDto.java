package agilefeedback.Dto;

import lombok.Data;

import java.util.List;

@Data
public class BacklogDto {
    private Long id;
    private Long projetId;
    private List<SprintDto> sprints;
}
