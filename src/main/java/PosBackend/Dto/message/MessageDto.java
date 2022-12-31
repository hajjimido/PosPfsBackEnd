package PosBackend.Dto.message;

import PosBackend.Domain.Enum.MessageType;
import PosBackend.Domain.Message;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDto {
    String id;
    String object;
    String sender;
    String message;
    MessageType messageType;
    boolean checked;
}
