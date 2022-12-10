package PosBackend.Mapper;

import PosBackend.Domain.Manager;
import PosBackend.Domain.Vendeur;
import PosBackend.Dto.user.ManagerDto;
import PosBackend.Dto.user.VendeurCreateDto;
import PosBackend.Dto.user.VendeurDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VendeurMapper {
    Vendeur toBo(VendeurCreateDto vendeurDto);
    //VendeurCreateDto toDto(Vendeur vendeur);
    @Mapping(target = "nameEntrepot",source = "vendeur.manager.entrepot.name")
    VendeurDto toDto(Vendeur vendeur);
    List<VendeurDto> toDto(List<Vendeur> vendeurs);
}
