package PosBackend.Dto.user;

import PosBackend.Dto.commande.CommandeDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@FieldDefaults(level = AccessLevel.PRIVATE)
public class VendeurDto extends UserDto{
    String nameEntrepot;
    List<CommandeDto> commandes;
}
