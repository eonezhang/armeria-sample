package com.eone.r2dbc;

import org.junit.jupiter.api.Test;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-1:20 PM
 */
class ConsumerTest {
    @Test
    void consume() throws Exception {
        Consumer consumer = new Consumer();
        consumer.consume();
    }

}