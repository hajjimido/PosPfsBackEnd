package PosBackend.Dto.produit;

import PosBackend.Dto.entrepot.EntrepotDto;
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
public class SharedProduitDto {
    //String nameEntrepot;
    String id;
    EntrepotDto entrepot;
    int capacite;
}
