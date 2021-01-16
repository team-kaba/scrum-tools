package com.example.domain.model;

public class ProductBacklogItem {
    private int storyPoint;
    private int passion;
    private String name;

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
}
