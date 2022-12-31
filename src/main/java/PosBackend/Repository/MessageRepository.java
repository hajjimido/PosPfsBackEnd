package PosBackend.Repository;

import PosBackend.Domain.Enum.MessageType;
import PosBackend.Domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,String> {
    List<Message> findByMessageType(MessageType messageType);

    List<Message> findByMessageTypeAndChecked(MessageType messageType, boolean checked);
}