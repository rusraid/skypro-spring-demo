package pro.sky.skyprospringdemo.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    public String hello() {
        return "<b>hello</b>";
    }

    public String answerHello(String userName) {
        return "<b>hello</b> " + userName;
    }
}
