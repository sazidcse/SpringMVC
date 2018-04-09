package com.controllers;

import com.handler.Bean;
import com.service.Story;
import com.service.StoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.sql.SQLException;
import java.util.List;

@Controller
public class StoryList {

    @GetMapping("/list_story")
    public String listStory(Model m) throws SQLException{

        StoryService storyService = new Bean("storyDao").getService();
        List<Story> storyList = storyService.getStoryList();
        m.addAttribute("storyList", storyList);

        return "story_list";
    }
}
