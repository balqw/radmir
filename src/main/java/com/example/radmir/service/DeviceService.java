package com.example.radmir.service;
import com.example.radmir.config.ConfigProperties;
import com.example.radmir.model.Device;
import com.example.radmir.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.format;

@Service
public class DeviceService {

    @Autowired
    private  DeviceRepository deviceRepository;
    @Autowired
    private  ConfigProperties properties;


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
        LocalDateTime time = LocalDateTime.now().minus(properties.getThresholdHours());
        return deviceRepository.findDevicesByLastResponseLessThanOrVolumeMeasuresLessThan(time, properties.getThresholdMeasures());
    }

}
