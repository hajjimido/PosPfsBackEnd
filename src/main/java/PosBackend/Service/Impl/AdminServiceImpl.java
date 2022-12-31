package PosBackend.Service.Impl;

import PosBackend.Domain.Admin;
import PosBackend.Dto.user.AdminCreateDto;
import PosBackend.Dto.user.AdminDto;
import PosBackend.Mapper.AdminMapper;
import PosBackend.Repository.AdminRepository;
import PosBackend.Service.AdminService;
import PosBackend.advice.Exception.UserException;
import PosBackend.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Override
    public AdminCreateDto getAdminConnected() {

            Optional<String> email= SecurityUtils.getUserEmail();
            if(email.isPresent()){
                Optional<Admin> admin=adminRepository.findByEmail(email.get());
                if(admin.isPresent()){
                    return adminMapper.toDto(admin.get());
                }
                throw  new UserException("user not found");

            }
            throw  new UserException("email not found");
        }


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
