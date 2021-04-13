package com.example.domain.model;

import com.example.infra.HostRepository;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Host {
  private String hostId;
  private String accountId;

  public Host(String accountId) {
    hostId = UUID.randomUUID().toString();
    this.accountId = accountId;
  }

  public boolean register(HostRepository hostRepository) {
    hostRepository.register(this);
    return true;
  }
}
