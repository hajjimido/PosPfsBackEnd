package PosBackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PROTECTED)
@JsonIgnoreProperties(value = {"entrepots","admin"},allowSetters = true)
public class Entreprise extends AbstractEntite{

    String name;
    @Column(unique = true)
    String patente;
    String adresse;
    String metier;
    @OneToOne(cascade = CascadeType.ALL)
    Admin admin;
    @OneToMany(mappedBy = "entreprise",fetch = FetchType.LAZY)
    List<Entrepot> entrepots;

}
