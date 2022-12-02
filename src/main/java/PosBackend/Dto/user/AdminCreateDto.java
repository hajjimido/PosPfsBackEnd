package PosBackend.Dto.user;

import PosBackend.Dto.entreprise.EntrepriseDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
@Data
@FieldDefaults(level = AccessLevel.PUBLIC)
public class AdminCreateDto extends UserCreateDto {

    public AdminCreateDto(String firstName, String lastName, String email, String phone, String password){
        super(firstName, lastName, email, phone, password);

    }


}
