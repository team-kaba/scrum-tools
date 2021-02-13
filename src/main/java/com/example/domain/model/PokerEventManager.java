package com.example.domain.model;

import java.util.List;

public class PokerEventManager {
  private List<ProductBacklogItem> productBacklogItems;
  private PokerEvent pokerEvent;

  /** 結果を送信していいかどうか判定する */
  boolean isOpen() {
    return pokerEvent.getCount() == productBacklogItems.size();
  }

  /** ProductBacklogItemを追加する */
  public void addProductBacklogItems(ProductBacklogItem productBacklogItem) {
    productBacklogItems.add(productBacklogItem);
  }

  public void setPokerEvent(PokerEvent pokerEvent) {
    this.pokerEvent = pokerEvent;
  }
}
