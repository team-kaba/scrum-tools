package com.example.domain.resource;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

public class ProductBacklogItemResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(0)
    private int storyPoint;

    @Min(1)
    @Max(3)
    private int passion;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    private OffsetDateTime accessAt;

    public int getStoryPoint() {
        return storyPoint;
    }

    public void setStoryPoint(int storyPoint) {
        this.storyPoint = storyPoint;
    }

    public int getPassion() {
        return passion;
    }

    public void setPassion(int passion) {
        this.passion = passion;
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
