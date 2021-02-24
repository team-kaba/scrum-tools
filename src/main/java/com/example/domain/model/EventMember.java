package com.example.domain.model;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventMember implements Serializable {
  private static final long serialVersionUID = 1L;
  /** ホストの人数 */
  private static final int numHost = 1;

  @NotBlank
  @Size(max = 12)
  private String hostName;

  @NotBlank
  @Size(max = 12)
  private List<String> guestNames;

  public int countMember() {
    return numHost + guestNames.size();
  }
}
