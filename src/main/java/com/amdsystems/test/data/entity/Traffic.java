package com.amdsystems.test.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data

public class Traffic implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int subscriberId;
    @NotNull
    @Column(name="time_stamp",columnDefinition="TIMESTAMP")
    private LocalDateTime timeStamp;

    @Column(nullable=true)
    private long trafficUplink;
    @Column(nullable=true)
    private long trafficDownlink;


    @ManyToOne
    @JoinColumn(name = "subscriberId", insertable=false, updatable=false)
    private Subscriber subscriber;
}
