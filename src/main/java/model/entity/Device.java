package model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial")
    private Long serialNum;
    private String typeOfProducer;
    private String typeOfDevice;
    private LocalDateTime lastResponse;
    private Long volumeMeasures;
}
