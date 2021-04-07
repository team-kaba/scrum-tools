package com.example.domain.service;

import com.example.domain.model.EventMember;
import com.example.domain.websocket_transceiver.ProductBacklogItemWebSocketReceiver;
import com.example.infra.PokerEventRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PokerEventService {

  private final PokerEventRepository pokerEventRepository;
  private final ProductBacklogItemWebSocketReceiver webSocketReceiver;

  public PokerEventService(
      PokerEventRepository pokerEventRepository,
      ProductBacklogItemWebSocketReceiver webSocketReceiver) {
    this.pokerEventRepository = pokerEventRepository;
    this.webSocketReceiver = webSocketReceiver;
  }

  public void create(EventMember eventMember) {
    // todo : ゲストがホストを確認するためにホストを一意に識別するIDを生成
    webSocketReceiver.create(eventMember);
    pokerEventRepository.registerMember(eventMember);
  }

  public List<EventMember> fetchEventMember() {
    return pokerEventRepository.fetch();
  }
}
