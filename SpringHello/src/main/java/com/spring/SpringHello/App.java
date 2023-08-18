package com.spring.SpringHello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.StudentB;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext a = new ClassPathXmlApplicationContext("Beans.xml");
        StudentB s1 = a.getBean("s2",StudentB.class);
        System.out.println(s1);
        a.registerShutdownHook(); 
    }
}
