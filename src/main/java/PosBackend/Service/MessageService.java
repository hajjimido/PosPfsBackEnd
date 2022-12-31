package PosBackend.Service;

import PosBackend.Domain.Enum.MessageType;
import PosBackend.Domain.Message;
import PosBackend.Dto.message.MessageDto;

import java.util.List;

public interface MessageService {
    void createMessage(MessageDto messageDto);
    List<MessageDto> getAllMessages();
    void deleteMessage(String id);

    List<MessageDto> getMessagesByType(String messageType);

    List<MessageDto> getNotCheckedMessagesByType(String messageType);

    void updateMessagetoChecked(String id);
}
