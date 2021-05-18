package com.example.radmir.service;
import com.example.radmir.model.entity.Device;
import com.example.radmir.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

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

}
