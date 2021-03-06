package com.example.radmir.service;
import com.example.radmir.config.ConfigProperties;
import com.example.radmir.model.Device;
import com.example.radmir.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final   DeviceRepository deviceRepository;

    private final ConfigProperties properties;

    @Transactional
    public Device getDeviceById(Long id){
        return deviceRepository.findById(id).orElseThrow(()->new IllegalArgumentException(format("no device found with serial =%d",id)));
    }

    @Transactional
    public List<Device>getDevices(){
        return deviceRepository.findAll();
    }
    @Transactional
    public Device editDeviceById(Device device){
        return deviceRepository.save(device);
    }
    @Transactional
    public Device saveDevice(Device device){
        return deviceRepository.save(device);
    }
    @Transactional
    public void deleteDeviceById(Long id){
       deviceRepository.deleteById(id);
    }
    @Transactional
    public List<Device>getBrokenDevices(){
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().minus(properties.getThresholdTime()));
        LocalDateTime time = LocalDateTime.now().minus(properties.getThresholdTime());
        return deviceRepository.findDevicesByLastResponseLessThanOrVolumeMeasuresLessThan(time, properties.getThresholdMeasures());
    }

}
