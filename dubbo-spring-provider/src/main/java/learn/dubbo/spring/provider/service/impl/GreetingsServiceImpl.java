package learn.dubbo.spring.provider.service.impl;

import learn.dubbo.spring.api.GreetingsService;

public class GreetingsServiceImpl implements GreetingsService {
    public String sayHi(String name) {
        return "hi, " + name;
    }
}
