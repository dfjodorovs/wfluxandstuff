package com.example.webfluxapp.fluxapp.routers;

import com.example.webfluxapp.fluxapp.handlers.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class PersonRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(PersonHandler personHandler){
        return RouterFunctions.route(GET("/hello2"),personHandler::handleAHellow)
                .andRoute(GET("/hello/{name}"),personHandler::handleAHellowWithParams)
                .andRoute(GET("/helloList"),personHandler::handleAHellowList);
    }
}
