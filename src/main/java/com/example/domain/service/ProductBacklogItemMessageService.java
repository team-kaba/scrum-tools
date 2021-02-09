package com.example.domain.service;

import com.example.domain.resource.ProductBacklogItemResource;

import java.util.List;

public class ProductBacklogItemMessageService {
    private int amount;
    private static int count;
    private List<ProductBacklogItemResource> productBacklogItemResources;

    public void create(int amount) {
        this.amount = amount;
    }

    public List<ProductBacklogItemResource> fetch(ProductBacklogItemResource productBacklogItemResource) {
        productBacklogItemResources.add(productBacklogItemResource);
        return productBacklogItemResources;
    }

    public List<ProductBacklogItemResource> send() {
        return this.productBacklogItemResources;
    }

    public boolean canSend() {
        return true;
    }
}

