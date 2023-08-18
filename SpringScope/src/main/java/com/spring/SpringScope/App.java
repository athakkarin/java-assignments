package com.spring.SpringScope;

import org.springframework.context.ApplicationContext;
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
        ApplicationContext a = new ClassPathXmlApplicationContext("Beans.xml");
        StudentB s = a.getBean("s",StudentB.class);
        s.setId(1);
        s.setFname("Vijay");
        s.setLname("Nehra");
        s.setEmail("vn@gmail.com");
        
        System.out.println(s);
        
        StudentB s1 = a.getBean("s",StudentB.class);
        System.out.println(s1);
    }
}
