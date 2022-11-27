package PosBackend.Mapper;

import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.VendeurCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendeurMapper {
    Vendeur toBo(VendeurCreateDto vendeurDto);
    VendeurCreateDto toDto(Vendeur vendeur);
}
