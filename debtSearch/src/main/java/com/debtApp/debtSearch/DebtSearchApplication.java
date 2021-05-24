package com.debtApp.debtSearch;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
//Disabled in yml
@EnableDiscoveryClient
@EnableCaching
public class DebtSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebtSearchApplication.class, args);
    }

    @Autowired
    private ReactorLoadBalancerExchangeFilterFunction lbFunction;

    @Configuration
    @LoadBalancerClient(name = "debtSearch")
    class WebClientConfig {

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

        @LoadBalanced
        @Bean
        WebClient.Builder webclientBuilder() {
            return WebClient.builder()
                    .baseUrl("http://debtSearch")
                    .filter(lbFunction)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .clientConnector(new ReactorClientHttpConnector(httpClient));
        }
    }

    @Configuration
    class DatabaseConfiguration{
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://kwecko:<Drumheads14>@sandbox.elvwf.mongodb.net/debtApp?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("debtApp");

    }

}
