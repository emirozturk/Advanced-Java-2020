package com.emirozturk.Rest;

import com.emirozturk.Entity.Channel;
import com.emirozturk.Service.IChannelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChannelRestController {
    IChannelService channelService;

    public ChannelRestController(IChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping("/channels")
    ResponseEntity<?> addChannel(@RequestBody Channel channel){
        Channel result = channelService.addChannel(channel);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/channels")
    ResponseEntity<?> updateChannel(@RequestBody Channel channel){
        Channel result = channelService.updateChannel(channel);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/channel/{id}")
    ResponseEntity<?> deleteChannel(@PathVariable int id){
        Channel result = channelService.deleteChannel(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/channels/{id}")
    ResponseEntity<?> getChannel(@PathVariable int id){
        Channel result = channelService.getChannel(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/channels")
    ResponseEntity<?> getChannels(){
        List<Channel> result = channelService.getChannels();
        return ResponseEntity.ok(result);
    }
    @PostMapping("/channel/{cid}/user/{uid}/auth/{auth}")
    ResponseEntity<?> addUserToChannel(@PathVariable int cid,@PathVariable int uid,@PathVariable int auth){
        Channel result = channelService.addUserToChannel(cid,uid,auth);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/channel/{cid}/user/{uid}")
    ResponseEntity<?> deleteUserFromChannel(@PathVariable int cid, @PathVariable int uid){
        Channel result = channelService.deleteUserFromChannel(cid,uid);
        return ResponseEntity.ok(result);
    }
}
