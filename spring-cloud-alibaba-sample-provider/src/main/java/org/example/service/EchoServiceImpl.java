package org.example.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.example.api.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Service
@Service
public class EchoServiceImpl implements EchoService {
    private final static Logger logger = LoggerFactory.getLogger(EchoServiceImpl.class);

    @Override
    public String echo(String message) {

        logger.info("Welcome to the spring cloud alibaba dubbo project!");

        return StringUtils.reverse(message);
    }

    @Override
    public String divide(Integer a, Integer b) {
        return null;
    }

    @Override
    public String notFound() {
        return null;
    }
}
