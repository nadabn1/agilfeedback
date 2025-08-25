package agilefeedback.Dto;
import lombok.Data;

@Data
public class InviteRequest {
    private Long clientId;
    private Long projetId;
    private String email;
    private String clientFullName;
    private Integer daysValid; // défaut 7
}
