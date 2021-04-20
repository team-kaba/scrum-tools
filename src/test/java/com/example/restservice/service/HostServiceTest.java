package com.example.restservice.service;

import static org.mockito.Mockito.doReturn;

import com.example.domain.model.Host;
import com.example.domain.service.HostService;
import com.example.infra.HostRepository;
import java.util.UUID;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HostServiceTest {
  @InjectMocks private HostService hostService;

  @Mock private HostRepository hostRepository;

  @Test
  public void testCreate() {
    String accountId = UUID.randomUUID().toString();
    Host resultHost = new Host(accountId);
    doReturn(resultHost).when(hostRepository).create(accountId);

    Host actualHost = hostService.create(accountId);
    Assertions.assertEquals(actualHost, resultHost);
  }
}
