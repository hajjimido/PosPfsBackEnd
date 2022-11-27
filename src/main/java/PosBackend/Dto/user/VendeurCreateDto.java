package PosBackend.Dto.user;

import PosBackend.Dto.entrepot.EntrepotDto;
import PosBackend.Dto.entreprise.EntrepriseDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VendeurCreateDto extends UserCreateDto {

   String idManager;
    public VendeurCreateDto(String firstName, String lastName, String email, String phone, String password,String idManager){
        super(firstName, lastName, email, phone, password);
        this.idManager=idManager;

    }
}
