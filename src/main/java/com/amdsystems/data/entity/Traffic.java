package com.amdsystems.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

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
