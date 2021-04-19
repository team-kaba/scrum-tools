package com.example.controller;

import com.example.domain.model.Guest;
import com.example.domain.service.GuestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "guest")
public class GuestController {

  private final GuestService guestService;

  public GuestController(GuestService guestService) {
    this.guestService = guestService;
  }

  public Guest create(String accountId) {
    return guestService.create(accountId);
  }
}
