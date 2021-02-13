package com.example.infra;

import com.example.domain.model.ProductBacklogItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface ProductBacklogItemRepository {
  void insert(ProductBacklogItem productBacklogItem);

  List<ProductBacklogItem> select(RowBounds rowBounds);
}
