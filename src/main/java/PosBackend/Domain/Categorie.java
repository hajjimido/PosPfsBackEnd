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

public class Categorie extends AbstractEntite{
    String nameCategorie;
    @ManyToMany(mappedBy = "categories")
    List<Entrepot> entrepots;
    @OneToMany(mappedBy ="categorie",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Produit> produits;

}
