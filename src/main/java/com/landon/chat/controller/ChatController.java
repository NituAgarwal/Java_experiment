package com.landon.chat.controller;

import com.landon.chat.model.ChatInMessage;
import com.landon.chat.model.ChatOutMessage;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.SendTo;

@Controller
public class ChatController {

    @MessageMapping("/guestchat")
    @SendTo("/topic/guestchats")
    public ChatOutMessage handleMessage(ChatInMessage inMessage) throws Exception{
        Thread.sleep(1000);
        inMessage = null;
        inMessage.getMessage();
        return new ChatOutMessage(inMessage.getMessage());
    }

    @MessageMapping("/guestupdate")
    @SendTo("/topic/guestupdates")
    public ChatOutMessage handleIsTyping(ChatInMessage inMessage) throws Exception{
        return new ChatOutMessage("Someone is Typing...");
    }

    @MessageMapping("/guestjoin")
    @SendTo("/topic/guestnames")
    public ChatOutMessage handleGuestName(ChatInMessage inMessage) throws Exception{
        return new ChatOutMessage(inMessage.getMessage());
    }

    @MessageExceptionHandler
    @SendTo("/topic/error")
    public ChatOutMessage handleException(Throwable exception){
        ChatOutMessage myError = new ChatOutMessage("An error occurred !!");
        return myError;
    }
}
