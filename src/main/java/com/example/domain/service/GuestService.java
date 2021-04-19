package com.example.domain.service;

import com.example.domain.model.Guest;
import com.example.infra.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

  private final GuestRepository guestRepository;

  public GuestService(GuestRepository guestRepository) {
    this.guestRepository = guestRepository;
  }

  public Guest create(String accountId) {
    return guestRepository.create(accountId);
  }
}
