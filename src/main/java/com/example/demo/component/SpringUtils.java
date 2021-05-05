package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class SpringUtils {
    public static ApplicationContext ctx;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext){
        ctx = applicationContext;
    }
}
