package com.example.domain.resource;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

public class ProductBacklogItemResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Pattern(regexp = "(?x) .? | ( \\\\2?+ (\\\\1|^.) )* ..")//FIXME : フィボナッチ数列 正規表現
    private String storyPoint;

    @Min(1)
    @Max(3)
    private int confidentDegree;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    private OffsetDateTime accessAt;

    public String getStoryPoint() {
        return storyPoint;
    }

    public void setStoryPoint(String storyPoint) {
        this.storyPoint = storyPoint;
    }

    public int getConfidentDegree() {
        return confidentDegree;
    }

    public void setConfidentDegree(int confidentDegree) {
        this.confidentDegree = confidentDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getAccessAt() {
        return accessAt;
    }

    public void setAccessAt(OffsetDateTime accessAt) {
        this.accessAt = accessAt;
    }

}
