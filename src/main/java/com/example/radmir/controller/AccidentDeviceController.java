package com.example.radmir.controller;

import com.example.radmir.model.Device;
import com.example.radmir.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/broken")
public class AccidentDeviceController {

    private final DeviceService deviceService;

    @GetMapping
    public List<Device> getProblemDevice(){
        return deviceService.getBrokenDevices();
    }

}
