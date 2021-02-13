package com.example.domain.service;

import com.example.domain.model.RefinementActor;
import com.example.domain.model.ProductBacklogItem;
import com.example.handler.RefinementActorListenerManager;
import com.example.infra.ProductBacklogItemRepository;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductBacklogItemService {
  private final ProductBacklogItemRepository productBacklogItemRepository;
  private final RefinementActorListenerManager listenerManger;

  private static final int OFFSET = 0;

  public ProductBacklogItemService(
      ProductBacklogItemRepository productBacklogItemRepository,
      RefinementActorListenerManager listenerManger) {
    this.productBacklogItemRepository = productBacklogItemRepository;
    this.listenerManger = listenerManger;
  }

  public void insert(ProductBacklogItem productBacklogItem) {
    productBacklogItemRepository.insert(productBacklogItem);
  }

  public List<ProductBacklogItem> select(String amount) {
    RowBounds rowBounds = new RowBounds(OFFSET, Integer.parseInt(amount));
    return productBacklogItemRepository.select(rowBounds);
  }

  public void create(int amount) {
    listenerManger.create(amount);
  }

  public void subscribe(RefinementActor actor) {
    listenerManger.subscribe(actor);
  }
}
