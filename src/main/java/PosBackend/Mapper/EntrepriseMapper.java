package PosBackend.Mapper;

import PosBackend.Domain.Entreprise;
import PosBackend.Dto.entreprise.EntrepriseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepriseMapper {
    Entreprise toBo(EntrepriseDto entrepriseDto);
    EntrepriseDto toDto(Entreprise entreprise);
}
