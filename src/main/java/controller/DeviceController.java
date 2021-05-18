package controller;

import lombok.RequiredArgsConstructor;
import model.entity.Device;
import org.springframework.web.bind.annotation.*;
import service.DeviceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping("device/{id}")
    public Device getDeviceById(@PathVariable("id")Long id){
        return deviceService.getDeviceById(id);
    }
}
