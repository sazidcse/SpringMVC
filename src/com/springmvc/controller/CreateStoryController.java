package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateStoryController {


    @GetMapping("/create_story")
    public String createStory(Model m) {

        return "create_story";
    }
}
