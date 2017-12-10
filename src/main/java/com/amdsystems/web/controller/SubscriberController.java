package com.amdsystems.web.controller;

import com.amdsystems.service.SubscriberService;
import com.amdsystems.web.model.TrafficModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SubscriberController {
    @Autowired
    SubscriberService subscriberService;

    @RequestMapping(value = {"/index","/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView getSubscribers(ModelAndView modelAndView) {
        modelAndView.addObject("names", subscriberService.getSubscribersNames());
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping(value = "/calc/{time1}/{time2}/{name}/{direction}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public TrafficModel getData(@PathVariable String time1, @PathVariable String time2,
                                @PathVariable String name, @PathVariable String direction) {

        long trafficOctets = subscriberService.calculateTraffic(time1, time2, name, direction);
        long trafficCapacity = subscriberService.calculateChannelCapacity(time1, time2, trafficOctets);

       return new TrafficModel(trafficOctets, trafficCapacity);
    }

}



