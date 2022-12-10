package PosBackend.Dto.produit;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProduitDto {
    String name;
    String reference;
    String nomProduit;
    int quantite;
    String nameCategorie;
    String detail;

}
