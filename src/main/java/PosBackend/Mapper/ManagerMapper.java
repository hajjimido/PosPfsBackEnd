package PosBackend.Mapper;

import PosBackend.Domain.Manager;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Dto.user.ManagerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    Manager toBo(ManagerCreateDto managerDto);
    //ManagerCreateDto toDto(Manager manager);
    //@Mapping(target = "nameEntrepot",source = "manager.entrepot.name")
    ManagerDto toDto(Manager manager);
    List<ManagerDto> toDto(List<Manager> manager);

}
