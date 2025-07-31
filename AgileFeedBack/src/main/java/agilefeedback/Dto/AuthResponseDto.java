package agilefeedback.Dto;


import lombok.*;

@Getter @Setter @AllArgsConstructor
public class AuthResponseDto {
    private String token;
    private String role;
}