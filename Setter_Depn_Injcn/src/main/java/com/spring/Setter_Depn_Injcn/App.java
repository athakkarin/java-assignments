package com.spring.Setter_Depn_Injcn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext a = new ClassPathXmlApplicationContext("Beans.xml");
        Employee e1 = a.getBean("e1", Employee.class);
        System.out.println(e1);
    }
}
