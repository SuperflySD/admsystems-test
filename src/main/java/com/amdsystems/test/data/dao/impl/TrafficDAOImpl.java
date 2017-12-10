package com.amdsystems.test.data.dao.impl;

import com.amdsystems.test.data.dao.TrafficDAO;
import com.amdsystems.test.data.entity.Traffic;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.math.BigDecimal;

@Repository
public class TrafficDAOImpl extends AbstractDAO<Traffic, Integer> implements TrafficDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    public TrafficDAOImpl() {
        super(Traffic.class);
    }

    public long getTraffic(String time1, String time2, String name, String direction) {
        BigDecimal traffic = (BigDecimal) entityManager.createNativeQuery(
                "SELECT sum(" + direction + ") FROM traffic " +
                        " inner join subscriber on traffic.subscriber_id = subscriber.id where subscriber.subscriber_name='" + name +
                        "' and traffic.time_stamp>'" + time1 + "' AND  traffic.time_stamp<'" + time2 + "'")
                .getSingleResult();
        return traffic == null ? 0 : traffic.longValue();

    }

}
