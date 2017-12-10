package com.amdsystems.data.dao;

import com.amdsystems.data.entity.Traffic;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficDAO extends  DAO<Traffic,Integer>{

     long getTraffic(String time1, String time2, String name, String direction);

}

