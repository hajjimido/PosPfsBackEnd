package PosBackend.Domain;

import PosBackend.Domain.Enum.MessageType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message extends AbstractEntite{
    String object;
    String sender;
    String message;
    @Enumerated(EnumType.STRING)
    MessageType messageType;
    @Column(columnDefinition = "boolean default false")
    boolean checked;

}
