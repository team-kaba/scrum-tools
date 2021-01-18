package com.example.domain.service;

import com.example.domain.mapper.ProductBacklogItemMapper;
import com.example.domain.model.ProductBacklogItem;
import com.example.domain.resource.ProductBacklogItemResource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductBacklogItemService {
    private final ProductBacklogItemMapper productBacklogItemMapper;

    private final static int OFFSET = 0;

    public ProductBacklogItemService(
            ProductBacklogItemMapper productBacklogItemMapper
    ) {
        this.productBacklogItemMapper = productBacklogItemMapper;
    }

    public void insert(ProductBacklogItemResource productBacklogItemResource) {
        productBacklogItemMapper.insert(productBacklogItemResource);
    }

    public List<ProductBacklogItem> select(String amount) {
        RowBounds rowBounds = new RowBounds(OFFSET, Integer.parseInt(amount));
        return productBacklogItemMapper.select(rowBounds);
    }

}

