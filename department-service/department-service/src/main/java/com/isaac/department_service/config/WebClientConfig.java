package com.isaac.department_service.config;

import com.isaac.department_service.client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Autowired
    private WebClient webClient;

    @Bean
    public WebClient emloyeeWebClient() {

        return WebClient.builder()
                .baseUrl("http://employee-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public EmployeeClient employeeClient(WebClient employeeWebClient){

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(employeeWebClient))
                .build();

//        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
//                .builder()
//                .build();

        return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }
}

