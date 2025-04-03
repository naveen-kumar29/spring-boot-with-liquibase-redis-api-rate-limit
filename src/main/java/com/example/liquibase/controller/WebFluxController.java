package com.example.liquibase.controller;

import com.example.liquibase.model.WebFlux;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class WebFluxController {

    @GetMapping("/api/hello")
    public List<WebFlux> getHello() throws Exception {
        Thread.sleep(2000);
        return  Arrays.asList(
                new WebFlux("1","Process 1"),
                new WebFlux("2","Process 2"),
                new WebFlux("3","Process 3"),
                new WebFlux("4","Process 4")
        );
    }
}
