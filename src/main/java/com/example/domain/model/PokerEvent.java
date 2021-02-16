package com.example.domain.model;

import java.util.ArrayList;
import java.util.List;

public class PokerEvent {

  /** イベントのメンバー数 */
  private final int count;

  private final List<ProductBacklogItem> productBacklogItems = new ArrayList<>();
  private final ProductBacklogItemSender sender;

  public PokerEvent(int count, ProductBacklogItemSender sender) {
    this.count = count;
    this.sender = sender;
  }

  private boolean isActive() {
    return count >= productBacklogItems.size();
  }

  /** 見積もり結果を送信します */
  private void send() {
    sender.send(productBacklogItems);
  }

  /** メンバーの見積もり結果を受け取ります */
  public void receive(ProductBacklogItem productBacklogItem) throws IllegalStateException {
    if (isActive()) {
      productBacklogItems.add(productBacklogItem);
      if (count == productBacklogItems.size()) {
        send();
      }
    } else {
      throw new IllegalStateException("No more requests can be accepted");
    }
  }
}
