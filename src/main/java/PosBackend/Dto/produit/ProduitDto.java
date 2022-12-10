package PosBackend.Dto.produit;


import PosBackend.Domain.SharedProduct;
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
public class ProduitDto {
    String id;
    String name;
    int quantite;
    String nameCatgorie;
    String reference;
    String detail;
    List<SharedProduitDto> sharedProducts;

}
