package PosBackend.Api;

import PosBackend.Domain.Admin;
import PosBackend.Dto.user.AdminCreateDto;
import PosBackend.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody AdminCreateDto adminDto){
        return ResponseEntity.ok().body(adminService.createAdmin(adminDto));
    }
    @PostMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody AdminCreateDto adminDto){
        return ResponseEntity.ok().body(adminService.createAdmin(adminDto));
    }

}
