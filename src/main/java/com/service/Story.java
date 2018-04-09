package com.service;

public class Story {
    private int storyId;
    private String storyTitle;
    private String storyAuthor;
    private String storyDetails;

    public Story() {
    }

    public Story(int storyId, String storyTitle, String storyAuthor, String storyDetails) {
        this.storyId = storyId;
        this.storyTitle = storyTitle;
        this.storyAuthor = storyAuthor;
        this.storyDetails = storyDetails;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryAuthor() {
        return storyAuthor;
    }

    public void setStoryAuthor(String storyAuthor) {
        this.storyAuthor = storyAuthor;
    }

    public String getStoryDetails() {
        return storyDetails;
    }

    public void setStoryDetails(String storyDetails) {
        this.storyDetails = storyDetails;
    }

}
