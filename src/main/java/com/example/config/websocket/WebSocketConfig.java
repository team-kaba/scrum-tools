package com.example.config.websocket;

import com.example.domain.service.ProductBacklogItemMessageService;
import com.example.handler.ProductBackLogItemWebSocketSender;
import com.example.handler.ProductBacklogItemWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final ObjectMapper objectMapper;
    private final ProductBacklogItemMessageService service;
    private final ProductBackLogItemWebSocketSender sender;

    public WebSocketConfig(ObjectMapper objectMapper, ProductBacklogItemMessageService service,
                           ProductBackLogItemWebSocketSender sender) {
        this.objectMapper = objectMapper;
        this.service = service;
        this.sender = sender;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(productBacklogItemWebSocketHandler(), "/product-backlog-item/send");
    }

    @Bean
    public WebSocketHandler productBacklogItemWebSocketHandler() {
        return new ProductBacklogItemWebSocketHandler(this.objectMapper, this.service, this.sender);
    }

}
