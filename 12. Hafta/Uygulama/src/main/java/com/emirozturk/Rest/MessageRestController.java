package com.emirozturk.Rest;

import com.emirozturk.Entity.Message;
import com.emirozturk.Service.IMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    private final IMessageService messageService;

    public MessageRestController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    ResponseEntity<?> postMessage(@RequestBody Message message){
        Message result = messageService.addMessage(message);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/message/{id}")
    ResponseEntity<?> deleteMessage(@PathVariable int id){
        Message result = messageService.deleteMessage(id);
        return ResponseEntity.ok(result);
    }
}
