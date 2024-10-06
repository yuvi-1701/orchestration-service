package com.microservices.demo.orchestration_service.service;

import com.microservices.demo.orchestration_service.client.Service2Client;
import com.microservices.demo.orchestration_service.client.Service3Client;
import com.microservices.demo.orchestration_service.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrchestrationService {

    private final Service2Client service2Client;
    private final Service3Client service3Client;

    public String orchestrate(UserRequest userRequest) {
        String service2Response = service2Client.getHello();

        String service3Response = service3Client.sendNameDetails(userRequest);

        return service2Response + " " + service3Response;
    }
}
