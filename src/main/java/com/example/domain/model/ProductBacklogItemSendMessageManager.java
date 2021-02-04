package com.example.domain.model;


public class ProductBacklogItemSendMessageManager {
    private static ProductBacklogItemSendMessageManager INSTANCE;
    private static int count;
    private final int amount;

    public ProductBacklogItemSendMessageManager create(int amount) {
        if (INSTANCE == null) {
            INSTANCE = new ProductBacklogItemSendMessageManager(amount);
        }
        return INSTANCE;
    }

    private ProductBacklogItemSendMessageManager(int amount) {
        this.amount = amount;
        this.count++;
    }

    public boolean canSend() {
        return this.amount == this.count;
    }
}

