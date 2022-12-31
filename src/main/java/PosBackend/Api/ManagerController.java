package PosBackend.Api;

import PosBackend.Domain.Entrepot;
import PosBackend.Domain.Manager;

import PosBackend.Dto.entrepot.EntrepotDto;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Dto.user.ManagerDto;
import PosBackend.Dto.user.VendeurDto;
import PosBackend.Service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerController {
    private final ManagerService managerService;


    @PostMapping("/create")
    public ResponseEntity<Manager> create(@RequestBody ManagerCreateDto managerCreateDto)  {
        return ResponseEntity.ok().body(managerService.createManager(managerCreateDto));
    }


    @GetMapping("/all")
    public ResponseEntity<List<ManagerDto>> getAllManagers(){
        return ResponseEntity.ok().body(managerService.getAllManagers());
    }
    @GetMapping("/vendeurs")
    public ResponseEntity<List<VendeurDto>> getManagerVedeurs(){
        return ResponseEntity.ok().body(managerService.getVendeursByManagerConnected());
    }
    @GetMapping("/produits")
    public ResponseEntity<List<ProduitDto>> getManagerProducts(){
        return ResponseEntity.ok().body(managerService.getProduitByManagerConnected());
    }
    @GetMapping("/entrepot")
    public ResponseEntity<EntrepotDto> getManagerEntrepot(){
        return ResponseEntity.ok().body(managerService.getEntrepotByManagerConnected());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Manager> getManager(@PathVariable(value="id") String id){
        return ResponseEntity.ok().body(managerService.getManager(id));
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
