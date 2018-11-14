package com.example.webfluxapp.fluxapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PersonControllers {


    @GetMapping("/hello")
    public Mono<String> getHello(){
        String hello = " Hello!";
        return Mono.just(hello);
    }

}
