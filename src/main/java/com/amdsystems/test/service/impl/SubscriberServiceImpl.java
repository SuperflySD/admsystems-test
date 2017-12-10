package com.amdsystems.test.service.impl;

import com.amdsystems.test.data.dao.SubscriberDAO;
import com.amdsystems.test.data.dao.TrafficDAO;
import com.amdsystems.test.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {
    @Autowired
    private SubscriberDAO subscriberDAO;
    @Autowired
    private TrafficDAO trafficDAO;

    @Override
    public List<String> getSubscribersNames() {
        return subscriberDAO.getSubscriberNames();
    }

    @Override
    public long calculateTraffic(String time1, String time2, String name, String direction) {
        return trafficDAO.getTraffic(time1, time2, name, direction);
    }

    @Override
    public long calculateChannelCapacity(String time1, String time2, Long trafficOctets) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime t1 = LocalDateTime.parse(time1, formatter);
        LocalDateTime t2 = LocalDateTime.parse(time2, formatter);
        long duration = Duration.between(t1, t2).getSeconds();
        if (duration != 0)
            return trafficOctets * 8 / duration;
        else return 0;
    }


}



