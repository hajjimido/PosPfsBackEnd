package PosBackend.Repository;

import PosBackend.Domain.Enum.MeetingType;
import PosBackend.Domain.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, String> {
    List<Meeting> findByMeetingType(MeetingType meetingType);
}
