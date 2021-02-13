package com.example.handler;

import com.example.domain.model.ProductBacklogItem;
import com.example.domain.model.RefinementActor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;

import java.io.IOException;
import java.util.List;

@Component
public class ProductBackLogItemWebSocketSender {
  private final ObjectMapper mapper;

  public ProductBackLogItemWebSocketSender(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public void send(List<RefinementActor> refinementActors) {
    refinementActors.forEach(
        e -> {
          WebSocketMessage<String> message;
          try {
            message = createWebSocketMessage(e.getProductBacklogItemResource());
            e.getWebSocketSession().sendMessage(message);
          } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
          } catch (IOException exception) {
            exception.printStackTrace();
          }
        });
  }

  private TextMessage createWebSocketMessage(ProductBacklogItem productBacklogItem)
      throws JsonProcessingException {
    return new TextMessage(mapper.writeValueAsString(productBacklogItem));
  }
}
