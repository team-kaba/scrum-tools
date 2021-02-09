package com.example.handler;

import com.example.domain.resource.ProductBacklogItemResource;
import com.example.domain.service.ProductBacklogItemMessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;

public class ProductBacklogItemWebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ProductBacklogItemMessageService service;
    private final ProductBackLogItemWebSocketSender sender;

    public ProductBacklogItemWebSocketHandler(ObjectMapper objectMapper, ProductBacklogItemMessageService service,
                                              ProductBackLogItemWebSocketSender sender) {
        this.objectMapper = objectMapper;
        this.service = service;
        this.sender = sender;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocketの接続が確立");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        try {
            ProductBacklogItemResource productBacklogItemResource
                    = objectMapper.readValue(payload, ProductBacklogItemResource.class);

            List<ProductBacklogItemResource> productBacklogItemResources = service.fetch(productBacklogItemResource);


            sender.send(session, productBacklogItemResources);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("WebSocketの接続が終了");
    }
}
