package PosBackend.Dto.meeting;

import PosBackend.Domain.Enum.MeetingType;
import PosBackend.Dto.user.ManagerDto;
import PosBackend.Dto.user.VendeurDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
public class MeetingDto implements Serializable {
    String id;
    LocalDateTime MeetingTime;
}
