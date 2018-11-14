package com.example.webfluxapp.fluxapp.client;

import com.example.webfluxapp.fluxapp.models.Person;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

public class Client {

    WebClient client = WebClient.create("http://localhost:8080");

    public void doStuff(){

        String stringMono = client.get()
                .uri("/hello")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("Hello result: " + stringMono);

        String stringMono2 = client.get()
                .uri("/hello2")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("Hello2 result: " + stringMono2);

        String someName = client.get()
                .uri("/hello/{name}","some name")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("Hello2 result: " + someName);

        client
                .get()
                .uri("/helloList")
//                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMapMany(response -> response.bodyToFlux(Person.class))
                .delayElements(Duration.ofMillis(1250))
                .subscribe(
                        s -> {
                            System.out.println( " >>>>>>>>>> " + s);
                        },
                        err->{
                            System.out.println( " Err ");
                        },
                        ()->{
                            System.out.println( " The end ");
                        }
                );
    }

}
