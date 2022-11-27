package PosBackend.Mapper;

import PosBackend.Domain.Produit;
import PosBackend.Dto.produit.ProduitDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produit toBo(ProduitDto produitDto);
    ProduitDto toDto(Produit produit);
}
