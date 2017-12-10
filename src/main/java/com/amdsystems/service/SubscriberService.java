package com.amdsystems.service;


import java.util.List;

public interface SubscriberService {

    List<String> getSubscribersNames();
    long calculateTraffic(String time1, String time2, String name, String direction);
    long calculateChannelCapacity(String time1, String time, Long trafficOctets);
}
