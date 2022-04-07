package com.sieun.metaChat;

import com.sieun.metaChat.handler.WebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@RequiredArgsConstructor
@EnableWebSocket // 웹 소켓 활성화
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler chatHandler;

    // 도메인이 다른 서버에서도 원활히 데이터를 주고받을 수 있도록 .setAllowedOrighins("*") -> 전부 다 받는 것으로 설정
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/chat").setAllowedOrigins("*"); // 웹 소켓에 연결할 주소 (ws://~~~/chat)
    }
}