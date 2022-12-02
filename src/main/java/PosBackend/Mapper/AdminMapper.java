package PosBackend.Mapper;
import PosBackend.Domain.Admin;
import PosBackend.Dto.user.AdminCreateDto;
import PosBackend.Dto.user.AdminDto;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin toBO(AdminDto adminDto);
    Admin toBO(AdminCreateDto adminDto);
    AdminCreateDto toDto(Admin admin);
}
