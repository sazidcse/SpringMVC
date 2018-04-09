package com.controllers;

import com.handler.Bean;
import com.handler.Validator;
import com.service.Story;
import com.service.StoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class UpdateStory {

    @GetMapping("/update_request/{story_id}")
    public String viewStory(@PathVariable int story_id, Model m) {

        StoryService storyService = new Bean("storyDao").getService();
        try {
            if (Validator.idValidator(story_id)) {
                Story story = storyService.getStoryDetails(story_id);
                m.addAttribute("story", story);
                return "update_story";
            } else {
                m.addAttribute("data", "Invalid story properties");
                return "error";
            }

        } catch (SQLException se){
            m.addAttribute("data", se);
            return "error";
        }
    }

    @RequestMapping(value="/update_request/update_story", method = RequestMethod.POST)
    public String save(@ModelAttribute("story")Story story, ModelMap m){

        StoryService storyService = new Bean("storyDao").getService();
        try {
            storyService.updateNewsStory(story);
            return "success";
        } catch (SQLException se){
            m.addAttribute("data", se);
            return "error";
        }

    }

}
