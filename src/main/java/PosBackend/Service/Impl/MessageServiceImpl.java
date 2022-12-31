package PosBackend.Service.Impl;


import PosBackend.Domain.Enum.MessageType;
import PosBackend.Domain.Message;
import PosBackend.Dto.message.MessageDto;
import PosBackend.Mapper.MessageMapper;
import PosBackend.Repository.MessageRepository;
import PosBackend.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;
    @Override
    public void createMessage(MessageDto messageDto) {
        messageRepository.save(messageMapper.toBo(messageDto));
    }

    @Override
    public List<MessageDto> getAllMessages() {
        return messageMapper.toDto(messageRepository.findAll());
    }

    @Override
    public void deleteMessage(String id)   {
        messageRepository.deleteById(id);
    }

    @Override
    public List<MessageDto> getMessagesByType(String messageType) {

        return messageMapper.toDto(messageRepository.findByMessageType(MessageType.valueOf(messageType)));
    }

    @Override
    public List<MessageDto> getNotCheckedMessagesByType(String messageType) {
      return  messageMapper.toDto( messageRepository.findByMessageTypeAndChecked(MessageType.valueOf(messageType),false));


    }

    @Override
    public void updateMessagetoChecked(String id) {
         Message message=messageRepository.findById(id).get();
        message.setChecked(true);
        messageRepository.save(message);

    }
}
