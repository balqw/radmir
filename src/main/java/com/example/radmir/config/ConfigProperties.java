package com.example.radmir.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


@Configuration
@ConfigurationProperties(prefix = "device")
@Data
public class ConfigProperties {
   private Duration thresholdTime;
   private Long thresholdMeasures;
}
