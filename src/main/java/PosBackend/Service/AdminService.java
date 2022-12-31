package PosBackend.Service;

import PosBackend.Domain.Admin;
import PosBackend.Dto.user.AdminCreateDto;
import PosBackend.Dto.user.AdminDto;

public interface AdminService {
    AdminCreateDto getAdminConnected();
    Admin createAdmin(AdminCreateDto adminDto);
    String updateAdmin(AdminDto adminDto);
}
