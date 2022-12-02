package PosBackend.Service.Impl;

import PosBackend.Domain.AdminMeeting;
import PosBackend.Domain.Enum.MeetingType;
import PosBackend.Domain.Manager;
import PosBackend.Domain.Meeting;
import PosBackend.Dto.meeting.AdminMeetingCreateDto;
import PosBackend.Dto.meeting.MeetingCreateDto;
import PosBackend.Mapper.MeetingMapper;
import PosBackend.Repository.MeetingRepository;
import PosBackend.Service.MeetingService;
import PosBackend.advice.Exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingServiceImpl implements MeetingService {
    private final MeetingRepository meetingRepository;
    private final MeetingMapper meetingMapper;

    @Override
    public Meeting createAdminMeeting(MeetingCreateDto meetingCreateDto){
        return createMeeting(meetingCreateDto,MeetingType.AdminMeeting);
    }

    @Override
    public Meeting createManagerMeeting(MeetingCreateDto meetingCreateDto){
        return createMeeting(meetingCreateDto,MeetingType.ManagerMeeting);
    }

    @Override
    public Meeting deleteMeeting(String id){
        Meeting meeting = meetingRepository.findById(id).orElseThrow(()->new UserException("Meeting not found for this id : "+id));
        meetingRepository.delete(meeting);
        return meeting;
    }

    @Override
    public Meeting updateMeeting(MeetingCreateDto meetingCreateDto) {
        return meetingRepository.save(meetingMapper.toBo(meetingCreateDto));
    }

    @Override
    public Meeting getMeeting(String id) {
        Meeting meeting = meetingRepository.findById(id).orElseThrow(()->new UserException("Meeting not found for this Id : "+id));
        return meeting;
    }

    @Override
    public List<Meeting> getAllAdminMeetings() {
        return meetingRepository.findByMeetingType(MeetingType.AdminMeeting);
    }

    @Override
    public List<Meeting> getAllManagerMeetings() {
        return meetingRepository.findByMeetingType(MeetingType.ManagerMeeting);
    }

    private Meeting createMeeting(MeetingCreateDto meetingCreateDto,MeetingType meetingType){
        Meeting meeting = meetingMapper.toBo(meetingCreateDto);
        meeting.setMeetingType(meetingType);
        return meetingRepository.save(meeting);
    }



}
