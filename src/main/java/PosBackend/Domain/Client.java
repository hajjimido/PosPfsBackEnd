package PosBackend.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Client {
    String firstName;
    String lastName;
    String phone;
    String Adresse;
}
