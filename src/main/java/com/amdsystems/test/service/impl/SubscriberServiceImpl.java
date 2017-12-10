package com.amdsystems.test.service.impl;

import com.amdsystems.test.data.dao.SubscriberDAO;
import com.amdsystems.test.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {
    @Autowired
    private SubscriberDAO subscriberDAO;

    @Override
    public List<String> getSubscribersNames() {
        return subscriberDAO.getSubscriberNames();
    }
}



