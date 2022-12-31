package PosBackend.Api;

import PosBackend.Domain.Enum.MessageType;
import PosBackend.Dto.message.MessageDto;
import PosBackend.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor

public class MessageController {
    private  final MessageService messageService;
    @PostMapping("/add")
    void createMessage(@RequestBody MessageDto messageDto){
        messageService.createMessage(messageDto);

    }
    @GetMapping("/all")
    List<MessageDto> getMessage(){
        return messageService.getAllMessages();
    }
    @GetMapping("/get/{type}")
    List<MessageDto> getMessageByTypeAndCheck(@PathVariable(value = "type" )String messageType ){

        return messageService.getMessagesByType(messageType);
    }
    @GetMapping("/getnotCheked/{type}")
    List<MessageDto> getNotCheckedMessageByType(@PathVariable(value = "type" )String messageType ){

        return messageService.getNotCheckedMessagesByType(messageType);
    }
    @PutMapping("/changeTochecked/{id}")
    public void changeMessagetochecked(@PathVariable(value = "id") String id){
        messageService.updateMessagetoChecked(id);

    }



    @DeleteMapping("/delete/{id}")
    void deleteMessage(@PathVariable(value = "id") String id){

        messageService.deleteMessage(id);
    }


}
