package agilefeedback.mapper;

import agilefeedback.Dto.UserDto;
import agilefeedback.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
