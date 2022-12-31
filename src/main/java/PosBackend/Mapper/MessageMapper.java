package PosBackend.Mapper;

import PosBackend.Domain.Message;
import PosBackend.Dto.message.MessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(target = "messageType",source = "messageType")
    Message toBo(MessageDto messageDto);
    @Mapping(target = "messageType",source = "messageType")
    @Mapping(target = "checked",source = "checked")
    MessageDto toDto(Message message);
    List<MessageDto> toDto(List<Message> messages);
}
