package com.example.domain.service;

import com.example.domain.model.ProductBacklogItem;
import com.example.infra.ProductBacklogItemRepository;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductBacklogItemService {
    private final ProductBacklogItemRepository productBacklogItemRepository;

    private final static int OFFSET = 0;

    public ProductBacklogItemService(
            ProductBacklogItemRepository productBacklogItemRepository
    ) {
        this.productBacklogItemRepository = productBacklogItemRepository;
    }

    public void insert(String amount) {
    }

    public List<ProductBacklogItem> select(String amount) {
        RowBounds rowBounds = new RowBounds(OFFSET, Integer.parseInt(amount));
        return productBacklogItemRepository.select(rowBounds);
    }

}

