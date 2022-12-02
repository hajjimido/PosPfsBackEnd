package PosBackend.Dto.entreprise;
import PosBackend.Dto.entrepot.EntrepotDto;
import PosBackend.Dto.user.AdminCreateDto;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Dto.user.VendeurCreateDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EntrepriseDto {
    String name;
    String patente;
    String adresse;
    String metier;
    AdminCreateDto admin;

}
