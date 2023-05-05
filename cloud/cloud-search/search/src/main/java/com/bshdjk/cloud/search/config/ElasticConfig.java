package com.bshdjk.cloud.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouxd
 * @since 2020-9-24
 */
@Configuration
public class ElasticConfig {

    @Value("${elastic.address}")
    private String esAddress;

    @Value("${elastic.port}")
    private int esPort;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(esAddress,esPort, "http")));
    }
}
