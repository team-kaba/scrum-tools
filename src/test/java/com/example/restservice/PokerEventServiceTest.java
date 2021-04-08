package com.example.restservice;

import com.example.domain.model.EventMember;
import com.example.domain.service.PokerEventService;
import com.example.domain.websocket_transceiver.ProductBacklogItemWebSocketReceiver;
import com.example.infra.PokerEventRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PokerEventServiceTest {
  @Mock PokerEventRepository pokerEventRepository;
  @Mock ProductBacklogItemWebSocketReceiver receiver;
  @InjectMocks private PokerEventService pokerEventService;

  @Test
  public void testFetchEventMember() {

    List<EventMember> actualEventMembers = pokerEventService.fetchEventMember();
  }
}
