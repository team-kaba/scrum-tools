package com.example.domain.service;

import com.example.domain.model.Host;
import com.example.infra.HostRepository;
import org.springframework.stereotype.Service;

@Service
public class HostService {

  private final HostRepository hostRepository;

  public HostService(HostRepository hostRepository) {
    this.hostRepository = hostRepository;
  }

  public Host create(String accountId) {
    return hostRepository.create(accountId);
  }
}
