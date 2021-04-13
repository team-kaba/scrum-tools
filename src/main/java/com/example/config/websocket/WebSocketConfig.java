package com.example.config.websocket;

import com.example.domain.service.ProductBacklogItemService;
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
  private final ProductBacklogItemService service;

  public WebSocketConfig(ObjectMapper objectMapper, ProductBacklogItemService service) {
    this.objectMapper = objectMapper;
    this.service = service;
  }

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(productBacklogItemWebSocketHandler(), "/product-backlog-item/send");
  }

  @Bean
  public WebSocketHandler productBacklogItemWebSocketHandler() {
    return new ProductBacklogItemWebSocketHandler(this.objectMapper, this.service);
  }
}
