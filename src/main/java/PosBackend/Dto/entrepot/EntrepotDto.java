package PosBackend.Dto.entrepot;
import PosBackend.Dto.categorie.CategorieDto;
import PosBackend.Dto.entreprise.EntrepriseDto;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Dto.user.VendeurCreateDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EntrepotDto {
    String adresse;
    String idEntreprise;
}
