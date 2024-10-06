package com.microservices.demo.orchestration_service.client;

import com.microservices.demo.orchestration_service.dto.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service3-client", url = "http://log-and-concatenate-service-4-env.eba-pihc9mzr.ap-southeast-2.elasticbeanstalk.com")
public interface Service3Client {

    @PostMapping("/api/v1/concatenate-log")
    String sendNameDetails(@RequestBody UserRequest UserRequest);
}
