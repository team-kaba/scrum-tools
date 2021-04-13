package com.example.domain.websocket_transceiver;

import com.example.domain.model.ProductBacklogItemSender;
import com.example.domain.model.ProductBacklogItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductBackLogItemWebSocketSender implements ProductBacklogItemSender {
  private final ObjectMapper mapper;
  private final List<WebSocketSession> webSocketSessions = new ArrayList<>();

  public ProductBackLogItemWebSocketSender(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  private TextMessage createWebSocketMessage(List<ProductBacklogItem> productBacklogItems)
      throws JsonProcessingException {
    return new TextMessage(mapper.writeValueAsString(productBacklogItems));
  }

  public void registerWebSocketSession(WebSocketSession session) {
    webSocketSessions.add(session);
  }

  public void clearWebSocketSession() {
    webSocketSessions.clear();
  }

  @Override
  public void send(List<ProductBacklogItem> productBacklogItems) {
    final TextMessage textMessage;
    try {
      textMessage = createWebSocketMessage(productBacklogItems);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return;
    }
    webSocketSessions.forEach(
        session -> {
          try {
            session.sendMessage(textMessage);
          } catch (IOException exception) {
            exception.printStackTrace();
          }
        });
    clearWebSocketSession();
  }
}
