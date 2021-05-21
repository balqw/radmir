package com.example.radmir.repository;

import com.example.radmir.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {

    List<Device> findDevicesByLastResponseLessThanOrVolumeMeasuresLessThan(@Param("t") LocalDateTime time,
                                                                           @Param("m") Long measure);

}
