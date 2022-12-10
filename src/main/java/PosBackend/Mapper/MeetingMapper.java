package PosBackend.Mapper;

import PosBackend.Domain.AdminMeeting;
import PosBackend.Domain.Meeting;
import PosBackend.Dto.meeting.AdminMeetingCreateDto;
import PosBackend.Dto.meeting.MeetingCreateDto;
import PosBackend.Dto.user.AdminCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeetingMapper {
    Meeting toBo(MeetingCreateDto meetingCreateDto);
    MeetingCreateDto toDto(Meeting meeting);
}
