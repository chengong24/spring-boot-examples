package com.neo;

import com.neo.aop.custom.IDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private IDemoService iDemoService;

    @Test
    public void contextLoads() {
        System.out.println("hello word");
    }

    @Test
    public void fun() {
        iDemoService.add(1, 2);
    }

}
