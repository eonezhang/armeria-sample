package me.eone.fakemall.common;

import java.util.function.Consumer;

import org.apache.curator.framework.imps.GzipCompressionProvider;
import org.apache.curator.retry.RetryForever;
import org.apache.thrift.TException;

import com.linecorp.armeria.common.thrift.ThriftFuture;
import com.linecorp.armeria.server.zookeeper.ZooKeeperRegistrationSpec;
import com.linecorp.armeria.server.zookeeper.ZooKeeperUpdatingListener;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-9:59 AM
 */
public class ThriftUtil {
    private static final String znodePath = "/armeria/services";

    public static Exception of(Throwable e) {
        return new TException(e);
    }

    public static void error(Consumer<Exception> consumer, Throwable e) {
        consumer.accept(of(e));
    }

    public static <T> ThriftFuture<T> newFuture() {
        return new ThriftFuture<>();
    }

    public static ZooKeeperUpdatingListener createListener(String zkConnectionStr, String serviceName) {
        ZooKeeperRegistrationSpec registrationSpec = ZooKeeperRegistrationSpec.curator(serviceName);
        ZooKeeperUpdatingListener listener = ZooKeeperUpdatingListener.builder(zkConnectionStr, znodePath, registrationSpec)
                                                                      .sessionTimeoutMillis(60000)
                                                                      .customizer(builder -> builder.canBeReadOnly(true)
                                                                                                    .retryPolicy(new RetryForever(10000))
                                                                                                    .maxCloseWaitMs(5000)
                                                                                                    .sessionTimeoutMs(60000)
                                                                                                    .waitForShutdownTimeoutMs(5000)
                                                                                                    .compressionProvider(new GzipCompressionProvider())
                                                                                                    .zk34CompatibilityMode(true))
                                                                      .build();
        return listener;
    }
}
