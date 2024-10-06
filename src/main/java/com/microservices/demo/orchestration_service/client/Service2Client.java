package com.microservices.demo.orchestration_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service2-client", url = "http://hello-service-4-env.eba-i7vmsbgq.ap-southeast-2.elasticbeanstalk.com")
public interface Service2Client {

    @GetMapping("/api/v1/hello")
    String getHello();
}
