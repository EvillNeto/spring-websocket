package br.com.evilnetodev.websocket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.evilnetodev.websocket.dtos.MessageWSDTO;
import br.com.evilnetodev.websocket.forms.MessageWSForm;
import br.com.evilnetodev.websocket.services.WSService;

@RestController
public class WebSocketController {

    @Autowired
    private WSService service;

    @MessageMapping("/message")
    public void sendMessage(@RequestBody MessageWSForm message) {
        service.sendTo("/topic/message", new MessageWSDTO(message.getMessage()));
    }

    @PostMapping("/ws/message")
    public String sendMessageToWS(@RequestBody MessageWSForm message) {
        service.sendTo("/topic/message", new MessageWSDTO(message.getMessage()));
        return "success";
    }
}