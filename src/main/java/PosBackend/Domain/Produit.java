package PosBackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;


import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PROTECTED)

@JsonIgnoreProperties(value={"categorie"},allowSetters = true)
public class Produit extends AbstractEntite {
    String name;
    int quantite;
    String detail;

    @Column(unique = true)
    String reference;
    @ManyToOne
    Categorie categorie;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "produit")
    List<SharedProduct> sharedProducts;

    //@ManyToMany
    //List<Commande> commandes;
}


