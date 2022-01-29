package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.service.HelloService;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String hello() {
        return helloService.hello();
    }

    @GetMapping(path = "/hello")
    public String answerHello(  String userName) {
        return helloService.answerHello(userName);
    }
}
