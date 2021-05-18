package com.example.radmir.controller;

import com.example.radmir.model.entity.Device;
import com.example.radmir.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping("/device/{id}")
    public Device getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }

    @GetMapping("/devices")
    public List<Device>getDevices(){
        return deviceService.getDevices();
    }

    @PutMapping("/device/edit/{id}")
    public Device editDevice(@PathVariable("id") Long id, @RequestBody Device device){
        device.setSerialNum(id);
        return deviceService.editDeviceById(device);
    }

    @PostMapping("/device")
    public Device createDevice(@RequestBody Device device){
        return deviceService.saveDevice(device);
    }

    @DeleteMapping("device/delete/{id}")
    public void deleteDeviceById(@PathVariable("id") Long id){
        deviceService.deleteDeviceById(id);
    }

}
