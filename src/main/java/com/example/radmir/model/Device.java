package com.example.radmir.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "device", schema = "public")
public class Device {

    @Id
    @Column(name = "serial")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long serialNum;
    @Column(name = "producer_type")
    private String typeOfProducer;
    @Column(name = "device_type")
    private String typeOfDevice;
    @Column(name = "last_response")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime lastResponse;
    @Column(name = "volume_measures")
    private Long volumeMeasures;
}
