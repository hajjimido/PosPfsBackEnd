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

@JsonIgnoreProperties(value = {"produits"},allowSetters = true)
public class Categorie extends AbstractEntite{
    @Column(unique = true)
    String nameCategorie;

    @OneToMany(mappedBy ="categorie",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Produit> produits;

}
