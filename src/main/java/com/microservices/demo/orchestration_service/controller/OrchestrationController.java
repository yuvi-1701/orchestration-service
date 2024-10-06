package com.microservices.demo.orchestration_service.controller;

import com.microservices.demo.orchestration_service.dto.UserRequest;
import com.microservices.demo.orchestration_service.service.OrchestrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class OrchestrationController {
    private final OrchestrationService orchestrationService;

    @GetMapping("/ping")
    public ResponseEntity<String> checkService(){
        return ResponseEntity.ok("Up");
    }

    @PostMapping("/saga")
    public ResponseEntity<String> orchestrateService(@RequestBody UserRequest userRequest){
        String traceId = UUID.randomUUID().toString();
        MDC.put("traceId", traceId);

        log.info("We are processing incoming request with trace ID: {}", traceId);

        String response;
        try{
            response =  orchestrationService.orchestrate(userRequest);
            log.info("Response generated for traceID: {}", traceId);
        } catch (Exception e){
            log.error("Error while processing request with trace ID: {} {}", traceId, e.getMessage());
            return ResponseEntity.status(500).body("Internal Server Error");
        } finally {
            MDC.clear(); // clearing the resources
        }
        return ResponseEntity.ok(response);
    }

}
