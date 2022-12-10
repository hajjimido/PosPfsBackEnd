package PosBackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.method.P;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"produit"},allowSetters = true)
public class SharedProduct extends AbstractEntite{

    @ManyToOne
    Produit produit;
    @ManyToOne
    Entrepot entrepot;

    int capacite;


}
