package PosBackend.Api;

import PosBackend.Domain.Manager;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/getManagers")
    public ResponseEntity<List<Manager>> getAllManagers(){
        return ResponseEntity.ok().body(managerService.getAllManagers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Manager> getManager(@PathVariable(value="id") String id){
        return ResponseEntity.ok().body(managerService.getManager(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Manager> createManager(@RequestBody ManagerCreateDto managerCreateDto){
        return ResponseEntity.ok().body(managerService.createManager(managerCreateDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Manager> deleteManager(@PathVariable(value = "id") String id){
        return ResponseEntity.ok().body(managerService.deleteManager(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable(value = "id") String id, @RequestBody ManagerCreateDto updatedManager){
        return ResponseEntity.ok().body(managerService.updateManager(id,updatedManager));
    }
}
