package com.xuecheng.orders.api;

import com.xuecheng.learning.feignclient.ContentServiceClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XuechengPlusOrdersApiApplicationTests {
    @Autowired
    ContentServiceClient contentServiceClient;

    @Test
    void contextLoads() {
    }

}
