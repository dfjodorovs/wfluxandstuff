package com.example.webfluxapp.fluxapp.handlers;

import com.example.webfluxapp.fluxapp.models.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PersonHandler {

    public Mono<ServerResponse> handleAHellow(ServerRequest request){

        String hello = " Hello2!";

        Mono<String> just = Mono.just(hello);
        return just.flatMap(
                s -> ServerResponse
                        .ok()
                        .body(fromObject(s)));
    }

    public Mono<ServerResponse> handleAHellowWithParams(ServerRequest serverRequest) {
        String hello = " Hello2!" + serverRequest.pathVariable("name");

        Mono<String> just = Mono.just(hello);
        return just.flatMap(
                s -> ok()
                        .body(fromObject(s)));
    }

    public Mono<ServerResponse> handleAHellowList(ServerRequest serverRequest) {
        List<Person> listOfStrings = new ArrayList<>();
        listOfStrings.add(new Person("Abols"));
        listOfStrings.add(new Person("Peteris"));
        listOfStrings.add(new Person("Abols2"));


        return ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(
                                Flux.fromIterable(listOfStrings), Person.class));
    }
}
