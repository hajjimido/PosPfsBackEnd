package PosBackend.Dto.commande;
import PosBackend.Dto.produit.ProduitDto;
import PosBackend.Dto.user.ClientDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommandeDto {
    ClientDto client;
    List<ProduitDto> produits;
}
