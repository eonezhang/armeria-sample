package com.eone.thrift.client;

import java.math.BigInteger;

import org.apache.thrift.TException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-3:51 PM
 */
class FooClientTest {

    @Test
    void testCall() throws TException, InterruptedException {
        FooClient client = new FooClient();
        client.call();
    }

    @Test
    void testRadix() {
        String name = "100";
        String radixVal = new BigInteger(1, name.getBytes()).toString(128);
        System.out.println("radixVal = " + radixVal);
    }
}