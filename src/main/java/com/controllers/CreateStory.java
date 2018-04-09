package com.controllers;

import com.handler.Bean;
import com.handler.Validator;
import com.service.Story;
import com.service.StoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
public class CreateStory {

    @GetMapping("/create_story")
    public String viewStory(Model m) throws SQLException{
        return "create_story";
    }


    @RequestMapping(value="/create_story", method = RequestMethod.POST)
    public String save(@ModelAttribute("story")Story story, ModelMap m){

        StoryService storyService = new Bean("storyDao").getService();
        try {
            if (Validator.storyValidator(story)) {
                storyService.createNewsStory(story);
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
