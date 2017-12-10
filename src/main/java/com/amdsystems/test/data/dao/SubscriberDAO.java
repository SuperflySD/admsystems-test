package com.amdsystems.test.data.dao;

import com.amdsystems.test.data.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SubscriberDAO extends JpaRepository<Subscriber, Integer> {

    @Query(value = "SELECT subscriber_name FROM subscriber", nativeQuery = true)
    List<String> getSubscriberNames();
}

