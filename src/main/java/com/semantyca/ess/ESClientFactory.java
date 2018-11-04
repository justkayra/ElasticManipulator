package com.semantyca.ess;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ESClientFactory {

    private RestHighLevelClient client;

    @Value("${elasticserver.host:localhost}")
    private String elasticServerHost = "localhost";

    @Value("${elasticserver.port:9200}")
    private int elasticServerPort = 9200;

    @PostConstruct
    void init() {
        this.client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(elasticServerHost.trim(), elasticServerPort, "http")));
    }

    @Bean
    public RestHighLevelClient get() {
        return client;
    }

}