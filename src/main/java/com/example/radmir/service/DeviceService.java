package com.example.radmir.service;
import com.example.radmir.model.entity.Device;
import com.example.radmir.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:accident.properties")
public class DeviceService {

    private final DeviceRepository deviceRepository;
    @Value("${thresholdTime}")
    private String thresholdTime;
    @Value("${thresholdMeasure}")
    private Long measure;

    public Device getDeviceById(Long id){
        return deviceRepository.findById(id).orElseThrow(()->new IllegalArgumentException(format("no device found with serial =%d",id)));
    }


    public List<Device>getDevices(){
        return deviceRepository.findAll();
    }

    public Device editDeviceById(Device device){
        return deviceRepository.save(device);
    }

    public Device saveDevice(Device device){
        return deviceRepository.save(device);
    }

    public void deleteDeviceById(Long id){
       deviceRepository.deleteById(id);
    }

    public List<Device>getBrokenDevices(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime time = LocalDateTime.parse(thresholdTime,dtf);
        return deviceRepository.findDevicesByLastResponseLessThanOrVolumeMeasuresLessThan(measure,time);
    }

}
