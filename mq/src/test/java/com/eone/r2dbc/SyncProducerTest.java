package com.eone.r2dbc;

import org.junit.jupiter.api.Test;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-10:42 AM
 */
class SyncProducerTest {

    @Test
    void testProducer() throws Exception {
        System.out.printf("start");
        SyncProducer producer = new SyncProducer();
        producer.sendMessage();
    }

    @Test
    void test1() {

    }

}