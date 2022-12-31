package PosBackend.Dto.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VendeurCreateDto extends UserCreateDto {


    String nameEntrepot;
    public VendeurCreateDto(String firstName, String lastName, String email, String phone, String password,String nameEntrepot,String username){
        super(firstName, lastName, email, phone, password,username);
        this.nameEntrepot=nameEntrepot;

    }
}
