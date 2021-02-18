package com.example.domain.service;

import com.example.domain.model.EventMember;
import com.example.infra.PorkerEventRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PorkerEventService {

  private final PorkerEventRepository porkerEventRepository;

  public PorkerEventService(PorkerEventRepository porkerEventRepository) {
    this.porkerEventRepository = porkerEventRepository;
  }

  public void registerMember(EventMember eventMember) {
    eventMember.setUuid(UUID.randomUUID());
    porkerEventRepository.registerMember(eventMember);
  }

  public List<EventMember> fetchEventMember() {
    return porkerEventRepository.fetch();
  }
}
