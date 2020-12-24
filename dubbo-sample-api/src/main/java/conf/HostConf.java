package conf;

public class HostConf {

    /**
     * zookeeper地址，默认值：127.0.0.1
     */
    public static final String zookeeperHost = System.getProperty("zookeeper.host", "127.0.0.1");

    /**
     * 端口号
     */
    public static final Integer zookerperPort = 2181;
}
