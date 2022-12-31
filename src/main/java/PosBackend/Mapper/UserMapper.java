package PosBackend.Mapper;

import PosBackend.Domain.User;
import PosBackend.Dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User User);
}
