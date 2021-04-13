package com.example.controller;

import com.example.controller.resource.PokerEventCreateResponse;
import com.example.domain.model.EventMember;
import com.example.domain.model.Host;
import com.example.domain.service.PokerEventService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokerEventController {

  private final PokerEventService pokerEventService;

  public PokerEventController(PokerEventService pokerEventService) {
    this.pokerEventService = pokerEventService;
  }

  @PostMapping(path = "poker-event/register")
  ResponseEntity<PokerEventCreateResponse> createPokerEvent(
      @RequestParam("account_id") String accountId, @RequestBody EventMember eventMember) {
    Host host = pokerEventService.create(eventMember, accountId);
    PokerEventCreateResponse pokerEventCreateResponse = new PokerEventCreateResponse();
    BeanUtils.copyProperties(host, pokerEventCreateResponse);
    return new ResponseEntity<>(pokerEventCreateResponse, HttpStatus.CREATED);
  }

  @GetMapping(path = "host-list/search")
  ResponseEntity<List<EventMember>> getPokerEvents() {
    List<EventMember> eventMembers = pokerEventService.fetchEventMember();
    return new ResponseEntity<>(eventMembers, HttpStatus.ACCEPTED);
  }
}
