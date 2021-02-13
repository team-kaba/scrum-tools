package com.example.handler;

import com.example.domain.model.RefinementActor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RefinementActorListenerManager {
  private static int amount;
  private final List<RefinementActor> refinementActors = new ArrayList<>();
  private final ProductBackLogItemWebSocketSender sender;

  public void create(int amount) {
    RefinementActorListenerManager.amount = amount;
  }

  public RefinementActorListenerManager(ProductBackLogItemWebSocketSender sender) {
    this.sender = sender;
  }

  public void subscribe(RefinementActor refinementActor) {
    if (amount >= refinementActors.size()) {
      refinementActors.add(refinementActor);
    }
    if (amount == refinementActors.size()) {
      sender.send(refinementActors);
    }
  }
}
