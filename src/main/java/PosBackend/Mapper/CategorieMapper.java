package PosBackend.Mapper;

import PosBackend.Domain.Categorie;
import PosBackend.Dto.categorie.CategorieDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategorieMapper {
    Categorie toBo(CategorieDto categorieDto);
    CategorieDto toDto(Categorie categorie);

}
