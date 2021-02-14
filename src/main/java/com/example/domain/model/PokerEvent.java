package com.example.domain.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PokerEvent {

  /** イベントのメンバー数 */
  private final int count;

  private final List<ProductBacklogItem> productBacklogItems = new ArrayList<>();
  private final ProductBacklogItemSender sender;

  public PokerEvent(int count, ProductBacklogItemSender sender) {
    this.count = count;
    this.sender = sender;
  }

  /** 見積もり結果を送信します */
  private void send() {
    sender.send(productBacklogItems);
  }

  /** メンバーの見積もり結果を受け取ります */
  public void receive(ProductBacklogItem productBacklogItem) {
    if (count >= productBacklogItems.size()) {
      productBacklogItems.add(productBacklogItem);
    }
    if (count == productBacklogItems.size()) {
      send();
    }
    // todo(例外をはく)
  }
}
