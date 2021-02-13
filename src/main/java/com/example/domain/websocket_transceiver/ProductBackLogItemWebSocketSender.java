package com.example.domain.websocket_transceiver;

import com.example.domain.model.ProductBacklogItemSender;
import com.example.domain.model.ProductBacklogItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductBackLogItemWebSocketSender implements ProductBacklogItemSender {
  private final ObjectMapper mapper;
  private final List<WebSocketSession> webSocketSessions = new ArrayList<>();

  public ProductBackLogItemWebSocketSender(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  // public void send(List<RefinementActor> refinementActors) {
  //  refinementActors.forEach(
  //      e -> {
  //        WebSocketMessage<String> message;
  //        try {
  //          message = createWebSocketMessage(e.getProductBacklogItem());
  //          e.getWebSocketSession().sendMessage(message);
  //        } catch (JsonProcessingException jsonProcessingException) {
  //          jsonProcessingException.printStackTrace();
  //        } catch (IOException exception) {
  //          exception.printStackTrace();
  //        }
  //      });
  // }

  private TextMessage createWebSocketMessage(ProductBacklogItem productBacklogItem)
      throws JsonProcessingException {
    return new TextMessage(mapper.writeValueAsString(productBacklogItem));
  }

  public void registerWebSocketSession(WebSocketSession session) {
    webSocketSessions.add(session);
  }

  @Override
  public void send(List<ProductBacklogItem> productBacklogItems) {
    System.out.println("OK");
  }
}
