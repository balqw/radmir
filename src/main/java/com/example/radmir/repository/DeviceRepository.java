package com.example.radmir.repository;

import com.example.radmir.model.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {


    @Query("SELECT d FROM Device d WHERE d.volumeMeasures < :m or d.lastResponse < :t" )
    List<Device> findDevicesByLastResponseLessThanOrVolumeMeasuresLessThan(@Param("m") Long measure,
                                                                           @Param("t") LocalDateTime time);

}
