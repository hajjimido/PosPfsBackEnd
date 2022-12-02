package PosBackend.Api;

import PosBackend.Domain.Entreprise;
import PosBackend.Dto.entreprise.EntrepriseDto;
import PosBackend.Service.EntrepriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entreprise")
public class EntrepriseController {
    private final EntrepriseService entrepriseService;

    @PostMapping("/create")
    public ResponseEntity<Entreprise> createEntrepriseWithAdmin(@RequestBody EntrepriseDto entrepriseDto){
        return ResponseEntity.ok().body( entrepriseService.createEntrepriseWithAdmin(entrepriseDto));

    }
}
