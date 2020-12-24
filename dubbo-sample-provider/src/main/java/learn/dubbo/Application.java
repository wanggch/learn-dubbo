package learn.dubbo;

import conf.HostConf;
import learn.dubbo.api.GreetingsService;
import learn.dubbo.service.impl.GreetingsServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;

public class Application {

    public static void main(String[] args) throws Exception {
        ServiceConfig<GreetingsService> service = new ServiceConfig<GreetingsService>();
        // 设置当前应用服务名称
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        // 设置注册中心地址
        service.setRegistry(new RegistryConfig("zookeeper://" + HostConf.zookeeperHost + ":" + HostConf.zookerperPort));
        service.setInterface(GreetingsService.class);
        service.setRef(new GreetingsServiceImpl());
        service.export();

        System.out.println("dubbo service started.");
        new CountDownLatch(1).await();
    }
}
