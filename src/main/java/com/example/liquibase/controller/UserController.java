package com.example.liquibase.controller;


import com.example.liquibase.entites.User;
import com.example.liquibase.model.WebFlux;
import com.example.liquibase.service.UserService;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


import java.time.Duration;
import java.util.List;



@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/create")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("/api/get-users/{id}")
    public User getUser(@PathVariable  Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/api/delete-users/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        return userService.deleteUser(id);
    }


    //Blocking client - synchronous
    @GetMapping("/rest-template")
    public List<WebFlux> restTemplate() {
        System.out.println("Starting RestTemplate Process");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<WebFlux>> restTemplat = restTemplate.exchange(
                "http://localhost:8080/api/hello",
                org.springframework.http.HttpMethod.GET,
                null,
                new org.springframework.core.ParameterizedTypeReference<List<WebFlux>>() {
                });

        //Blocking client
        List<WebFlux> response = restTemplat.getBody();
        response.forEach(webFlux -> {
            System.out.println("Response: " + webFlux.getName() + " " + webFlux.getDescription());
        });

//        String url = "http://localhost:8080/api/hello";
//        //Blocking client
//        WebFlux[] response = restTemplate.getForObject(url, WebFlux[].class);
//
//        if (response != null) {
//            for (int i = 0; i < response.length; i++) {
//                System.out.println("Response: " + response[i].getName() + " " + response[i].getDescription());
//            }
//            return List.of(response);
//        }


        System.out.println("Exit RestTemplate Process");
        return response;
    }


    //Non-Blocking Client - asynchronous
    @GetMapping("/webflux")
    public Flux<WebFlux> webflux() {
        System.out.println("Starting WebFlux Process");
        Flux<WebFlux> flux = WebClient.create()
                        .get()
                        .uri("http://localhost:8080/api/hello")
                        .retrieve()
                        .bodyToFlux(WebFlux.class);

        //non - blocking - create evet queue
        flux.subscribe(webFlux -> {
            System.out.println("Response: " + webFlux.getName() + " " + webFlux.getDescription());
        });

        System.out.println("Exit WebFlux Process");
        return flux;
    }
}
