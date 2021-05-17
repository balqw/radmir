package controller;

import lombok.RequiredArgsConstructor;
import model.entity.Device;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.DeviceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping
    public Device getDeviceById(@RequestParam("id")Long id){
        return deviceService.getDeviceById(id);
    }
}
