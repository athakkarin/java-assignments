package com.spring.Object_Depn_Injcn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.EmployeeB;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext a = new ClassPathXmlApplicationContext("Beans.xml");
        EmployeeB empb = (EmployeeB) a.getBean("employeeb");
        empb.emp();
    }
}
