package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.Category;
import com.domain.Hero;
import com.service.HeroService;

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
 
        Category c = (Category) context.getBean("c");
         
        System.out.println(c.getName());
        
        Hero h = (Hero) context.getBean("h");
        System.out.println(h.getName());
        System.out.println(h.getCategory().getName());
        
        HeroService s = (HeroService) context.getBean("s");
        s.doSomeService();
    }
}
