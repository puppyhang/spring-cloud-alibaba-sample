package org.example.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.example.api.EchoService;
import org.example.feign.EchoServiceByFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class DubboBootstrapServiceController {
    private final static Logger logger = LoggerFactory.getLogger(DubboBootstrapServiceController.class);

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RestTemplate restTemplate1;

    @Reference
    private EchoService echoServiceDubbo;

    @Resource
    private EchoServiceByFeign echoServiceFeign;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/echo-dubbo/{str}")
    public String dubbo(@PathVariable String str) {
        return echoServiceDubbo.echo(str);
    }

    @GetMapping("/echo-rest/{str}")
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://service-provider/echo/" + str,
                String.class);
    }

    @GetMapping("/index")
    public String index() {

        return restTemplate1.getForObject("http://service-provider", String.class);
    }

    @GetMapping("/test")
    public String test() {

        return restTemplate1.getForObject("http://service-provider/test", String.class);
    }

    @GetMapping("/sleep")
    public String sleep() {

        return restTemplate1.getForObject("http://service-provider/sleep", String.class);
    }

    @GetMapping("/notFound-feign")
    public String notFound() {

        return echoServiceFeign.notFound();
    }

    @GetMapping("/divide-feign")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {

        return echoServiceFeign.divide(a, b);
    }

    @GetMapping("/divide-feign2")
    public String divide(@RequestParam Integer a) {

        return echoServiceFeign.divide(a, 2);
    }

    @GetMapping("/echo-feign/{str}")
    public String feign(@PathVariable String str) {

        return echoServiceFeign.echo(str);
    }

    @GetMapping("/services/{service}")
    public Object client(@PathVariable String service) {

        return discoveryClient.getInstances(service);
    }

    @GetMapping("/services")
    public Object services() {

        return discoveryClient.getServices();
    }
}
