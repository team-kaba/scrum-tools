package com.example.handler;

import com.example.domain.model.RefinementActor;
import com.example.domain.model.ProductBacklogItem;
import com.example.domain.service.ProductBacklogItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ProductBacklogItemWebSocketHandler extends TextWebSocketHandler {

  private final ObjectMapper objectMapper;
  private final ProductBacklogItemService service;

  public ProductBacklogItemWebSocketHandler(
      ObjectMapper objectMapper, ProductBacklogItemService service) {
    this.objectMapper = objectMapper;
    this.service = service;
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    System.out.println("WebSocketの接続が確立");
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    final String payload = message.getPayload();
    ProductBacklogItem productBacklogItem =
        objectMapper.readValue(payload, ProductBacklogItem.class);
    service.insert(productBacklogItem);
    service.subscribe(new RefinementActor(session, productBacklogItem));
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    System.out.println("WebSocketの接続が終了");
  }
}
