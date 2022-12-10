package PosBackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PROTECTED)
@JsonIgnoreProperties(value = {"manager","sharedProducts"},allowSetters = true)

public class Entrepot extends AbstractEntite{
    @Column(unique = true)
    String name;
    String city;
    @Column(unique = true)
    String patente;
    String adresse;
    String region;
    @OneToOne(mappedBy = "entrepot")
    Manager manager;
    @ManyToOne
    Entreprise entreprise;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "entrepot")
    List<SharedProduct> sharedProducts;

}
