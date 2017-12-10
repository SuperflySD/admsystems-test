package com.amdsystems.test.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data

public class Traffic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int subscriberId;
    @NotNull
    private LocalDateTime timeStamp;
    @Column(nullable=true)
    private long trafficUplink;
    @Column(nullable=true)
    private long trafficDownlink;


    @ManyToOne
    @JoinColumn(name = "subscriberId", insertable=false, updatable=false)
    private Subscriber subscriber;
}
