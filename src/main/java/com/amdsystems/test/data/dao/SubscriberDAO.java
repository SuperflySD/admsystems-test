package com.amdsystems.test.data.dao;

import com.amdsystems.test.data.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberDAO extends JpaRepository<Subscriber, Integer> {

    @Query(value = "select subscriber.subscriber_name from subscriber", nativeQuery = true)
    public List<String> getSubscriberNames();


}

