package agilefeedback.Dto;

import lombok.*;

@Getter @Setter
public class AuthRequestDto {
    private String email;
    private String password;
}