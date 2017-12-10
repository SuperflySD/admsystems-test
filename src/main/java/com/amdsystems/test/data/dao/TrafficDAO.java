package com.amdsystems.test.data.dao;

import com.amdsystems.test.data.entity.Subscriber;
import com.amdsystems.test.data.entity.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrafficDAO extends  DAO<Traffic,Integer>{

     long getTraffic(String time1, String time2, String name, String direction);

}

