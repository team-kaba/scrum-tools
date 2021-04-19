package com.example.domain.model;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Host {
  private static final int COUNT = 1;
  private String hostId;
  private String accountId;

  public Host(String accountId) {
    hostId = UUID.randomUUID().toString();
    this.accountId = accountId;
  }

  public static int getCount() {
    return Host.COUNT;
  }
}
