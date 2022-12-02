package PosBackend.Domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Manager extends User{

    @OneToOne(mappedBy = "manager")
    Entrepot entrepot;
    @OneToMany(mappedBy = "manager",fetch = FetchType.LAZY)
    List<Vendeur> vendeurs;


}
