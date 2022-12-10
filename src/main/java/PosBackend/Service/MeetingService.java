package PosBackend.Service;

import PosBackend.Domain.Meeting;
import PosBackend.Dto.meeting.MeetingCreateDto;

import java.util.List;

public interface MeetingService {
    Meeting createAdminMeeting(MeetingCreateDto meetingCreateDto);

    Meeting createManagerMeeting(MeetingCreateDto meetingCreateDto);

    Meeting deleteMeeting(String id);

    Meeting updateMeeting(MeetingCreateDto meetingCreateDto);

    Meeting getMeeting(String id);

    List<Meeting> getAllAdminMeetings();

    List<Meeting> getAllManagerMeetings();
}
