package com.example.domain.service;

import com.example.domain.model.ProductBacklogItem;
import com.example.domain.websocket_transceiver.ProductBacklogItemWebSocketReceiver;
import com.example.infra.ProductBacklogItemRepository;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.WebSocketSession;

@Transactional
@Service
public class ProductBacklogItemService {
  private final ProductBacklogItemRepository repository;
  private final ProductBacklogItemWebSocketReceiver receiver;

  private static final int OFFSET = 0;

  public ProductBacklogItemService(
      ProductBacklogItemRepository repository, ProductBacklogItemWebSocketReceiver receiver) {
    this.repository = repository;
    this.receiver = receiver;
  }

  public void insert(ProductBacklogItem productBacklogItem, WebSocketSession session) {
    repository.insert(productBacklogItem);
    receiver.receive(productBacklogItem, session);
  }

  public List<ProductBacklogItem> select(String amount) {
    RowBounds rowBounds = new RowBounds(OFFSET, Integer.parseInt(amount));
    return repository.select(rowBounds);
  }

}
