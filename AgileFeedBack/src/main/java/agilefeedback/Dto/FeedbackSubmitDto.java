package agilefeedback.Dto;
import lombok.Data;

@Data
public class FeedbackSubmitDto {
    private String token;
    private String type;
    private String commentaire;
}
