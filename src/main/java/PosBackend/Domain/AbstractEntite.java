package PosBackend.Domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PROTECTED)
@Data
 public abstract class AbstractEntite implements Serializable {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Id
    String id;

    @CreatedDate
    Instant creationDate;

    @LastModifiedDate
    Instant modifiedDate;

}
