package com.example.controller.resource;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokerEventCreateResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String hostId;
}
