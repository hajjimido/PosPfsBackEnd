package PosBackend.Domain;

import PosBackend.Dto.user.ManagerDto;
import PosBackend.Dto.user.VendeurDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ManagerMeeting extends Meeting {
    @ManyToOne
    private Manager manager;
    @ElementCollection
    List<Vendeur> vendeurs;
}
