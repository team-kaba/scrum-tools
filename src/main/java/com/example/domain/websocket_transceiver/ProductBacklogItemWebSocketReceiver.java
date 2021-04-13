package com.example.domain.websocket_transceiver;

import com.example.domain.model.PokerEvent;
import com.example.domain.model.ProductBacklogItem;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ProductBacklogItemWebSocketReceiver {
  private final ProductBackLogItemWebSocketSender sender;
  private PokerEvent pokerEvent;

  public ProductBacklogItemWebSocketReceiver(ProductBackLogItemWebSocketSender sender) {
    this.sender = sender;
  }

  public void receive(ProductBacklogItem productBacklogItem, WebSocketSession session) {
    sender.registerWebSocketSession(session);
    pokerEvent.receive(productBacklogItem);
  }
}
