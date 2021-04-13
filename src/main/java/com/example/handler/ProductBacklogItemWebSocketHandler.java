package com.example.handler;

import com.example.domain.model.ProductBacklogItem;
import com.example.domain.service.ProductBacklogItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ProductBacklogItemWebSocketHandler extends TextWebSocketHandler {

  private final ObjectMapper objectMapper;
  private final ProductBacklogItemService service;
  private final Logger logger = LoggerFactory.getLogger(ProductBacklogItemWebSocketHandler.class);

  public ProductBacklogItemWebSocketHandler(
      ObjectMapper objectMapper, ProductBacklogItemService service) {
    this.objectMapper = objectMapper;
    this.service = service;
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      logger.info("WebSocket connection is connected");
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    final String payload = message.getPayload();
    logger.info("WebSocket Client Message : " + payload);
    ProductBacklogItem productBacklogItem =
        objectMapper.readValue(payload, ProductBacklogItem.class);
    service.insert(productBacklogItem, session);
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    logger.info("WebSocket connection is closed");
  }
}
