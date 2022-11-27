package PosBackend.Mapper;

import PosBackend.Domain.Manager;
import PosBackend.Dto.user.ManagerCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    Manager toBo(ManagerCreateDto managerDto);
    ManagerCreateDto toDto(Manager manager);
}
