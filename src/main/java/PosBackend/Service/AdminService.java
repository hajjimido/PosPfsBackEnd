package PosBackend.Service;

import PosBackend.Domain.Admin;
import PosBackend.Dto.user.AdminCreateDto;
import PosBackend.Dto.user.AdminDto;

public interface AdminService {
    Admin createAdmin(AdminCreateDto adminDto);
    String updateAdmin(AdminDto adminDto);
}
