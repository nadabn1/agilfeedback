package agilefeedback.Dto;

import agilefeedback.model.Enum.RoleType;
import lombok.Data;

@Data
public class SmDto {
    private Long id;
    private String email;
    private RoleType role;
}
