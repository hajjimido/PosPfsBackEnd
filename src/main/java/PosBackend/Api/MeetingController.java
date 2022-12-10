package PosBackend.Api;

import PosBackend.Domain.Manager;
import PosBackend.Domain.Meeting;
import PosBackend.Domain.Vendeur;
import PosBackend.Dto.meeting.MeetingCreateDto;
import PosBackend.Dto.user.ManagerCreateDto;
import PosBackend.Service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meeting")
public class MeetingController {

    private final MeetingService meetingService;

    @GetMapping("/getAdminMeetings")
    public ResponseEntity<List<Meeting>> getAllAdminMeetings(){
        return ResponseEntity.ok().body(meetingService.getAllAdminMeetings());
    }

    @GetMapping("/getManagerMeetings")
    public ResponseEntity<List<Meeting>> getAllManagerMeetings(){
        return ResponseEntity.ok().body(meetingService.getAllManagerMeetings());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Meeting> getMeeting(@PathVariable(value="id") String id){
        return ResponseEntity.ok().body(meetingService.getMeeting(id));
    }

    @PostMapping("/createManagerMeeting")
    public ResponseEntity<Meeting> createManagerMeeting(@RequestBody MeetingCreateDto meetingCreateDto){
        return ResponseEntity.ok().body(meetingService.createManagerMeeting(meetingCreateDto));
    }

    @PostMapping("/createAdminMeeting")
    public ResponseEntity<Meeting> createAdminMeeting(@RequestBody MeetingCreateDto meetingCreateDto){
        return ResponseEntity.ok().body(meetingService.createAdminMeeting(meetingCreateDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Meeting> deleteMeeting(@PathVariable(value = "id") String id){
        return ResponseEntity.ok().body(meetingService.deleteMeeting(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Meeting> updateMeeting(@PathVariable(value = "id") String id, @RequestBody MeetingCreateDto updatedMeeting){
        return ResponseEntity.ok().body(meetingService.updateMeeting(updatedMeeting));
    }
}
