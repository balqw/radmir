package service;

import lombok.RequiredArgsConstructor;
import model.entity.Device;
import org.springframework.stereotype.Service;
import repository.DeviceRepository;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Device getDeviceById(Long id){
        return deviceRepository.getOne(id);
    }

}
