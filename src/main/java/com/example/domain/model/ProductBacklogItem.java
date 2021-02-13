package com.example.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
public class ProductBacklogItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Size(min = 1, max = 3)
  @Pattern(regexp = "[12358|13]") // FIXME : フィボナッチ数列 正規表現
  private String storyPoint;

  @Min(1)
  @Max(3)
  private int confidentDegree;

  @NotBlank
  @Size(max = 50)
  private String name;

  @NotNull private OffsetDateTime accessAt;
}
