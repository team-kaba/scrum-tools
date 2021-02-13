package com.example.domain.websocket_transceiver;

import com.example.domain.model.PokerEvent;
import com.example.domain.model.ProductBacklogItem;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ProductBacklogItemWebSocketReceiver {
  private PokerEvent pokerEvent;
  private final ProductBackLogItemWebSocketSender sender;

  public void create(int amount) {
    this.pokerEvent = new PokerEvent(amount, sender);
  }

  public ProductBacklogItemWebSocketReceiver(ProductBackLogItemWebSocketSender sender) {
    this.sender = sender;
  }

  public void receive(ProductBacklogItem productBacklogItem, WebSocketSession session) {
    pokerEvent.receive(productBacklogItem);
    sender.registerWebSocketSession(session);
  }
}
