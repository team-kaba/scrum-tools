package com.example.domain.model;

public class ProductBacklogItem {
    private String storyPoint;
    private int passion;
    private String name;

    public String getStoryPoint() {
        return storyPoint;
    }

    public void setStoryPoint(String storyPoint) {
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
}
