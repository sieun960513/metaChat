package com.sieun.metaChat.controller;

import com.sieun.metaChat.dto.ChatMessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompChatController {
    private final SimpMessagingTemplate template; // 특정 Broker로 메시지를 전달

    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessageDTO message) {
        message.setMessage(message.getWriter() + "님이 채팅방에 입장하였습니다.");
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageDTO message) {
        template.convertAndSend("sub/chat/room/" + message.getRoomId(), message);
    }
}