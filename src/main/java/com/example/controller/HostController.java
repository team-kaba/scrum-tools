package com.example.controller;

import com.example.domain.model.Host;
import com.example.domain.service.HostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("host")
public class HostController {

  private final HostService hostService;

  public HostController(HostService hostService) {
    this.hostService = hostService;
  }

  @PostMapping(path = "create")
  public Host create(@RequestParam("account_id") String accountId) {
    return hostService.create(accountId);
  }
}
