package org.example.feign;

import org.springframework.context.annotation.Bean;

public class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {

        return new EchoServiceFallback();
    }
}
