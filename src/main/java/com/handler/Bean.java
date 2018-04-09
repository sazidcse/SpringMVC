package com.handler;

import com.service.StoryService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean {
    private String springBean;

    public Bean(String springBean) {
        this.springBean = springBean;
    }

    public StoryService getService() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StoryService storyService = (StoryService) context.getBean(springBean);
        return storyService;
    }
}
