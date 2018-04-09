package com.handler;

import com.service.Story;

public class Validator {

    public static boolean storyValidator(Story story) {
        if (story.getStoryAuthor().equals("")) return false;
        if (story.getStoryTitle().equals("")) return false;
        if (story.getStoryDetails().equals("")) return false;
        return true;
    }

    public static boolean idValidator(int id) {
        return id == 0 ? false : true;
    }
}
