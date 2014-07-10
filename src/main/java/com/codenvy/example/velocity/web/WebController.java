package com.codenvy.example.velocity.web;

import com.codenvy.example.velocity.FeedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    private FeedService feedService;

    @Autowired
    public WebController(FeedService feedService) {
        this.feedService = feedService;
    }

    @RequestMapping("/")
    public String list(ModelMap model) {
        model.put("feeds", feedService.getFeeds());
        return "list";
    }

    @RequestMapping("/feed/{id}")
    public String detail(@PathVariable(value = "id") Integer feedId, ModelMap model) {
        model.put("feed", feedService.getFeedById(feedId));
        return "detail";
    }
}
