package com.debtApp.debt.controller;

import com.debtApp.debt.model.DebtItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class DebtClient {

    Logger log = LoggerFactory.getLogger(DebtClient.class.getSimpleName());

    @Autowired
    WebClient webClient;

    @Value("${env}")
    private String env;

    @RequestMapping("/client/{id}")
    DebtItem getDebtItemById(@PathVariable("id") int id){
        log.info("inside get client by id");
        Mono<DebtItem> result = webClient.get()
                .uri(env+"/debt/{id}",id)
                .retrieve()
                .bodyToMono(DebtItem.class);
        return result.block();
    }
}
