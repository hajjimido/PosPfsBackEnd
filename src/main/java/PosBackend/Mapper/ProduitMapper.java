package PosBackend.Mapper;

import PosBackend.Domain.Produit;
import PosBackend.Dto.produit.CreateProduitDto;
import PosBackend.Dto.produit.ProduitDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    Produit toBo(ProduitDto produitDto);
    Produit toBo(CreateProduitDto createProduitDto);
    @Mapping(source = "produits",target="produits")
    List<Produit> toBoListProduit(List<ProduitDto> produitDtoList);
    @Mapping(source = "categorie.nameCategorie" ,target = "nameCatgorie")
    ProduitDto toDto(Produit produit);

}
