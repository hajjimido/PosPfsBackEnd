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
@JsonIgnoreProperties(value = {"manager","categories"},allowSetters = true)

public class Entrepot extends AbstractEntite{
    String adresse;
    @OneToOne
    Manager manager;

    @ManyToOne
    Entreprise entreprise;
    @ManyToMany(fetch = FetchType.LAZY)
    List<Categorie> categories;

}
