package com.example.config.websocket;

import com.example.handler.ProductBacklogItemWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(productBacklogItemWebSocketHandler(), "/product-backlog-item/send");
    }

    @Bean
    public WebSocketHandler productBacklogItemWebSocketHandler() {
        return new ProductBacklogItemWebSocketHandler();
    }
}
