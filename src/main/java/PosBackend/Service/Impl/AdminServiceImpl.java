package PosBackend.Service.Impl;

import PosBackend.Domain.Admin;
import PosBackend.Dto.user.AdminCreateDto;
import PosBackend.Dto.user.AdminDto;
import PosBackend.Mapper.AdminMapper;
import PosBackend.Repository.AdminRepository;
import PosBackend.Service.AdminService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    @Override
    public Admin createAdmin(AdminCreateDto adminDto) {
        return adminRepository.save(adminMapper.toBO(adminDto));
    }

    @Override
    public String updateAdmin(AdminDto adminDto) {
        if(findAdminByEmail(adminDto)) {
            adminRepository.save(adminMapper.toBO(adminDto));
        }
        else throw new UserException("user not found");
        return "admin updated with sucess";
    }

    private boolean findAdminByEmail(AdminDto adminDto){
         return adminRepository.findByEmail(adminDto.getEmail()).isPresent();

    }
}
