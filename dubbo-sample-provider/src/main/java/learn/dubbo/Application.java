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
        ApplicationConfig applicationConfig = new ApplicationConfig("first-dubbo-provider");

        ServiceConfig<GreetingsService> service = new ServiceConfig<>();
        service.setApplication(applicationConfig);
        // 设置注册中心地址
        service.setRegistry(new RegistryConfig("zookeeper://" + HostConf.zookeeperHost + ":" + HostConf.zookerperPort));
        service.setInterface(GreetingsService.class);
        service.setRef(new GreetingsServiceImpl());
        // 显露及注册服务
        service.export();

        System.out.println("dubbo service started.");
        new CountDownLatch(1).await();
    }
}
