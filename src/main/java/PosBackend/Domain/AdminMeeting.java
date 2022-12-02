package PosBackend.Domain;

import PosBackend.Dto.user.AdminDto;
import PosBackend.Dto.user.ManagerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdminMeeting extends Meeting {
    @ManyToOne
    private Admin admin;
    @ElementCollection
    List<Manager> managers;
}
