package agilefeedback.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ValidateResponse {
    private boolean ok;
    private String status;            // "ok" | "invalid" | "used" | "expired"
    private String clientFullName;
    private Long clientId;            // (optionnel) null si tu ne veux pas l'exposer
}
