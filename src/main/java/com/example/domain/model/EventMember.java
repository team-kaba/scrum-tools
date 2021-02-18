package com.example.domain.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventMember implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID uuid;

    @NotBlank
    @Size(max = 12)
    private String hostName;

    @NotBlank
    @Size(max = 12)
    private List<String> guestNames;
}