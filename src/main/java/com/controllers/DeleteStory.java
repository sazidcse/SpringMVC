package com.controllers;

import com.handler.Bean;
import com.handler.Validator;
import com.service.StoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class DeleteStory {

    @GetMapping("/delete_request/{story_id}")
    public String viewStory(@PathVariable int story_id, Model m)  {

        StoryService storyService = new Bean("storyDao").getService();
        try {
            if (Validator.idValidator(story_id)) {
                storyService.deleteNewsStory(story_id);
                return "success";
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
