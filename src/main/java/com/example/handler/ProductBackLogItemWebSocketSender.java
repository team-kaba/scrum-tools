package com.example.handler;

import com.example.domain.resource.ProductBacklogItemResource;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

public class ProductBackLogItemWebSocketSender {

    public void send(WebSocketSession session, List<ProductBacklogItemResource> resources) {

        // session.sendMessage();
    }
}
