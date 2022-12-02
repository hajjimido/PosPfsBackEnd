package PosBackend.Api;

import PosBackend.Domain.Categorie;
import PosBackend.Dto.categorie.CategorieDto;
import PosBackend.Service.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/categorie")
@RequiredArgsConstructor
@RestController
public class CategorieController {
    private final CategorieService categorieService;

    @PostMapping("/add")
    public ResponseEntity<Categorie> addCategorie(@RequestBody CategorieDto categorieDto){
        return ResponseEntity.ok().body(categorieService.addCategorie(categorieDto));

    }
    @DeleteMapping ("/delete/{name}")
    public ResponseEntity<String> deleteCategorie(@PathVariable String name){
        return ResponseEntity.ok().body(categorieService.deleteCategorie(name));

    }
    @PutMapping ("/delete/{name}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable CategorieDto categorieDto){
        return ResponseEntity.ok().body(categorieService.updateCategorie(categorieDto));

    }
}
