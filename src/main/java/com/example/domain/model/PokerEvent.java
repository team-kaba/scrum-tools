package com.example.domain.model;

import java.util.ArrayList;
import java.util.List;

public class PokerEvent {

  private final List<ProductBacklogItem> productBacklogItems = new ArrayList<>();

  private final ProductBacklogItemSender sender;
  private final List<Guest> guests;
  private final Host host;

  private PokerEvent(ProductBacklogItemSender sender, List<Guest> guests, Host host) {
    this.guests = guests;
    this.sender = sender;
    this.host = host;
  }

  public static PokerEvent of(
      Host host, List<Guest> guests, ProductBacklogItemSender sender) {
    return new PokerEvent(sender, guests, host);
  }

  private int countMembers() {
    return Host.getCount() + guests.size();
  }

  private boolean isActive() {
    return countMembers() >= productBacklogItems.size();
  }

  /** 見積もり結果を送信します */
  private void send() {
    sender.send(productBacklogItems);
  }

  /** メンバーの見積もり結果を受け取ります */
  public void receive(ProductBacklogItem productBacklogItem) throws IllegalStateException {
    if (isActive()) {
      productBacklogItems.add(productBacklogItem);
      if (countMembers() == productBacklogItems.size())
        send();
    } else
      throw new IllegalStateException("No more requests can be accepted");
  }
}
