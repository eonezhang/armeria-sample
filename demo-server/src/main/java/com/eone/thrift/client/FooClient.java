package com.eone.thrift.client;

import java.util.concurrent.CountDownLatch;
import java.util.function.Function;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eone.service.test.thrift.main.FooService;
import com.eone.service.test.thrift.main.FooStruct;
import com.linecorp.armeria.client.Clients;
import com.linecorp.armeria.client.HttpClient;
import com.linecorp.armeria.client.logging.LoggingClient;
import com.linecorp.armeria.common.logging.LogLevel;
import com.linecorp.armeria.common.thrift.ThriftFuture;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-3:47 PM
 */
public class FooClient {

    void call() throws TException, InterruptedException {

        Logger log = LoggerFactory.getLogger(FooClient.class);

        CountDownLatch latch = new CountDownLatch(1);
        Function<? super HttpClient, LoggingClient> newDecorator = LoggingClient.builder()
                                                                                .logger(log)
                                                                                .requestLogLevel(LogLevel.DEBUG)
                                                                                .successfulResponseLogLevel(LogLevel.DEBUG)
                                                                                .samplingRate(1.0f)
                                                                                .newDecorator();
        FooService.AsyncIface fooService = Clients.builder("tbinary+http://127.0.0.1:8080/hello")
                                                  .responseTimeoutMillis(10000)
                                                  .decorator(newDecorator)
                                                  .build(FooService.AsyncIface.class);

        FooStruct foo = new FooStruct();
        foo.setDoubleVal(123.111).setBoolVal(false);
        ThriftFuture<FooStruct> future = new ThriftFuture<>();
        fooService.bar3(1, foo, future);

        future.thenAccept(response -> {
            System.out.printf("==%s%n", response);
            latch.countDown();
        }).exceptionally(cause -> {
            cause.printStackTrace();
            latch.countDown();
            return null;
        });
        latch.await();
    }
}
