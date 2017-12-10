package com.amdsystems.test.web.controller;

import com.amdsystems.test.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SubscriberController {
    @Autowired
    SubscriberService subscriberService;

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ModelAndView getSubscribers(ModelAndView modelAndView) {
        modelAndView.addObject("names", subscriberService.getSubscribersNames());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/greeting")
    public ModelAndView greeting(ModelAndView model) {
        model.addObject("name", "fcdsgfgv");
        model.setViewName("greeting");
        return model;
    }

}



