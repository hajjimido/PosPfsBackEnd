package PosBackend.Dto.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManagerCreateDto extends UserCreateDto {

    String nameEntrepot;

    public ManagerCreateDto(String firstName, String lastName, String email, String phone, String password,String nameEntrepot){
        super(firstName, lastName, email, phone, password);
        this.nameEntrepot=nameEntrepot;

    }
}
