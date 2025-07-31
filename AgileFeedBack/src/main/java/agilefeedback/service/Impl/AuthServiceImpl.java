package agilefeedback.service.Impl;

import agilefeedback.Dto.AuthRequestDto;
import agilefeedback.Dto.AuthResponseDto;
import agilefeedback.model.User;
import agilefeedback.repository.UserRepository;
import agilefeedback.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public AuthResponseDto login(AuthRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return new AuthResponseDto("Login failed", null);
        }

        return new AuthResponseDto("Login success", user.getRole().name());
    }

}
