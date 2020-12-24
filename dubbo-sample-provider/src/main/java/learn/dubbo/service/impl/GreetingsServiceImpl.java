package learn.dubbo.service.impl;

import learn.dubbo.api.GreetingsService;

public class GreetingsServiceImpl implements GreetingsService {
    public String sayHi(String name) {
        return "hi, " + name;
    }
}
