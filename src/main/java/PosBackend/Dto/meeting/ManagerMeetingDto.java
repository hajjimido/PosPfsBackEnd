package PosBackend.Dto.meeting;

import PosBackend.Dto.user.AdminDto;
import PosBackend.Dto.user.ManagerDto;
import PosBackend.Dto.user.VendeurCreateDto;
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
public class ManagerMeetingDto extends MeetingDto  {
    ManagerDto meetingHost;
    List<VendeurDto> meetingAttendees;
}