package PosBackend.Api;

import PosBackend.Domain.Commande;
import PosBackend.Dto.commande.CommandeDto;
import PosBackend.Service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
@RequiredArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    @PostMapping("/add")
    public ResponseEntity<Commande> addCommande(@RequestBody CommandeDto commandeDto){
        return ResponseEntity.ok().body(commandeService.addCommande(commandeDto));

    }
    @GetMapping("/all")
    public ResponseEntity<List<CommandeDto>> getCommandes(){
        return ResponseEntity.ok().body(commandeService.getCommandes());

    }
    @GetMapping("/all/{entrepot}")
    public ResponseEntity<List<CommandeDto>> getCommandesInEntrepots(@PathVariable(value = "entrepot" )String entrepot){
        return ResponseEntity.ok().body(commandeService.getCommandesInEntrepot(entrepot));

    }
    @GetMapping("/userConnected/all")
    public ResponseEntity<List<CommandeDto>> getUserConnectedCommandes(){
        return ResponseEntity.ok().body(commandeService.getManagerConnectedCommandes());

    }
    @DeleteMapping("/delete/{id}")
    public void deleteCommande(@PathVariable(value = "id") String id){
         commandeService.deleteCommande(id);

    }



}
