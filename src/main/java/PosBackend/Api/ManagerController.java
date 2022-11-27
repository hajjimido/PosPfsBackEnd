package PosBackend.Api;

import PosBackend.Domain.Manager;
import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerController {
    private final ManagerService managerService;

    @PostMapping("/create")
    public ResponseEntity<Manager> create(@RequestBody ManagerCreateDto managerCreateDto){
        return ResponseEntity.ok().body(managerService.createManager(managerCreateDto));

    }
}
