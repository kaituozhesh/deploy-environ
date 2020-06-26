package com.ktz.deploy.websocket.controller;

import com.ktz.deploy.websocket.config.WebsocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.client.WebSocketClient;

import java.io.IOException;
import java.net.Socket;


/**
 * @ClassName : WsController
 * @Description :
 * @Author : kaituozhesh
 * @Date: 2020-06-26 14:44
 * @Version: 1.0.0
 */
@RestController
public class WsController {
    @PostMapping("/push")
    public String push(@RequestParam String message, @RequestParam String userId) {
        try {
            WebsocketServer.sendInfo(message, userId);
            return "Message send success!";
        } catch (IOException e) {
            return "Message send fail";
        }
    }

}
