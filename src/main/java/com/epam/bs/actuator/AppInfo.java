package com.epam.bs.actuator;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "appInfo")
@RequiredArgsConstructor
public class AppInfo {

    @Autowired
    private final Environment environment;

    @Value("${spring.datasource.url}")
    private String dbUrl ;

    @ReadOperation
    public Map<String,String> getProfileInfo() {

        return Map.of("Profiles", String.join(", ", environment.getActiveProfiles()),
                      "db_url", dbUrl);
    }
}