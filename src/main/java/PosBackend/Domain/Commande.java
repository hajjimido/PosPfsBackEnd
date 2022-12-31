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
@JsonIgnoreProperties(value = {"vendeur"})
public class Commande extends AbstractEntite{
    @Embedded
    Client client;
    @ManyToOne
    Vendeur vendeur;
    @ManyToMany
    List<Produit> produits;
}
