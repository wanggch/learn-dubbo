package learn.dubbo;

import conf.HostConf;
import learn.dubbo.api.GreetingsService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

public class Application {

    public static void main(String[] args) {
        ReferenceConfig<GreetingsService> reference = new ReferenceConfig<>();
        // 设置当前应用服务名称
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        // 设置注册中心地址
        reference.setRegistry(new RegistryConfig("zookeeper://" + HostConf.zookeeperHost + ":" + HostConf.zookerperPort));
        reference.setInterface(GreetingsService.class);
        GreetingsService service = reference.get();
        String message = service.sayHi("dubbo");
        System.out.println(message);
    }
}
