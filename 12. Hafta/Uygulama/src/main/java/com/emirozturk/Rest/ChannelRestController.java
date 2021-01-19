package com.emirozturk.Rest;

import com.emirozturk.Entity.Channel;
import com.emirozturk.Security.BildirimUserDetails;
import com.emirozturk.Service.IChannelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    ResponseEntity<?> getChannel(@PathVariable int id, Principal principal){
        var user = ((BildirimUserDetails)((UsernamePasswordAuthenticationToken)principal).getPrincipal());
        if(user.getChannels().stream().map(x->x.getChannel().getId()==id).toArray().length>0) {
            Channel result = channelService.getChannel(id);
            return ResponseEntity.ok(result);
        }
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HttpStatus.BAD_REQUEST);
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
