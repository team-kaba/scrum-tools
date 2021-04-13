package com.example.domain.model;

import java.util.ArrayList;
import java.util.List;

public class PokerEvent {

  private static final PokerEvent instance = new PokerEvent();
  private final List<ProductBacklogItem> productBacklogItems = new ArrayList<>();

  private ProductBacklogItemSender sender;
  private EventMember eventMember;

  private PokerEvent() {}

  public static PokerEvent of() {
    return PokerEvent.instance;
  }

  public void create(EventMember eventMember, ProductBacklogItemSender sender) {
    this.eventMember = eventMember;
    this.sender = sender;
  }

  private boolean isActive() {
    return eventMember.countMember() >= productBacklogItems.size();
  }

  /** 見積もり結果を送信します */
  private void send() {
    sender.send(productBacklogItems);
  }

  /** メンバーの見積もり結果を受け取ります */
  public void receive(ProductBacklogItem productBacklogItem) throws IllegalStateException {
    if (isActive()) {
      productBacklogItems.add(productBacklogItem);
      if (eventMember.countMember() == productBacklogItems.size())
        send();
    } else
      throw new IllegalStateException("No more requests can be accepted");
  }
}
