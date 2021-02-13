package com.example.domain.model;

import java.util.List;

public interface ProductBacklogItemSender {
  void send(List<ProductBacklogItem> productBacklogItems);
}
