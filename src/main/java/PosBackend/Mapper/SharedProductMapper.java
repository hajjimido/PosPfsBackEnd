package PosBackend.Mapper;

import PosBackend.Domain.SharedProduct;
import PosBackend.Dto.produit.SharedProduitDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SharedProductMapper {

    //@Mapping(source = "sharedProduit.entrepot.name",target = "nameEntrepot")
    SharedProduitDto toDto(SharedProduct sharedProduit);

    List<SharedProduitDto> toDto(List<SharedProduct> sharedProduits);

}
