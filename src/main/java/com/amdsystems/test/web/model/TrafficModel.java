package com.amdsystems.test.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TrafficModel {

    private long trafficOctets;
    private long trafficCapacity;

    public TrafficModel(long trafficOctets, long trafficCapacity) {
        this.trafficOctets = trafficOctets;
        this.trafficCapacity = trafficCapacity;
    }
}
