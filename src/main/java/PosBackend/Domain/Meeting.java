package PosBackend.Domain;

import PosBackend.Domain.Enum.MeetingType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PROTECTED)
@Inheritance
@Data
public class Meeting extends AbstractEntite{
    LocalDateTime meetingTime;
    MeetingType meetingType;
}
