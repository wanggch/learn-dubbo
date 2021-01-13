package learn.dubbo.spring.api;

public interface GreetingsService {

    /**
     * say嗨
     * @param name 名称
     * @return
     */
    String sayHi(String name);
}
