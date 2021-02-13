package com.example.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

/** こいつがpubでありsubでもある */
@Getter
@Setter
public class RefinementActor {

  ProductBacklogItem productBacklogItem;

  WebSocketSession webSocketSession;
}
