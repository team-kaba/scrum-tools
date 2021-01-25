package com.example.infra;

import com.example.domain.model.ProductBacklogItem;
import com.example.domain.resource.ProductBacklogItemResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface ProductBacklogItemRepository {
    void insert(ProductBacklogItemResource productBacklogItemResource);

    List<ProductBacklogItem> select(RowBounds rowBounds);
}
