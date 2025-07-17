package agilefeedback.service;


import agilefeedback.Dto.AuthRequestDto;
import agilefeedback.Dto.AuthResponseDto;

public interface AuthService {
    AuthResponseDto login(AuthRequestDto request);
}
