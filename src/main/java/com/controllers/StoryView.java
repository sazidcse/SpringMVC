package com.controllers;

import com.handler.Bean;
import com.handler.Validator;
import com.service.Story;
import com.service.StoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.sql.SQLException;

@Controller
public class StoryView {

    @GetMapping("/view_story/{story_id}")
    public String viewStory(@PathVariable int story_id, Model m) {

        StoryService storyService = new Bean("storyDao").getService();
        try {
            if (Validator.idValidator(story_id)) {
                Story story = storyService.getStoryDetails(story_id);
                m.addAttribute("story", story);
                return "story_view";
            } else {
                m.addAttribute("data", "Invalid story properties");
                return "error";
            }

        } catch (SQLException se){
            m.addAttribute("data", se);
            return "error";
        }

    }
}
