package PosBackend.Dto.user;

import PosBackend.Dto.entrepot.EntrepotDto;
import PosBackend.Dto.entreprise.EntrepriseDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VendeurCreateDto extends UserCreateDto {


    String nameEntrepot;
    public VendeurCreateDto(String firstName, String lastName, String email, String phone, String password,String nameEntrepot){
        super(firstName, lastName, email, phone, password);
        this.nameEntrepot=nameEntrepot;

    }
}
