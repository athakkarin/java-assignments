package com.spring.Constructor_Depn_Injcn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.EmployeeB;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext a = new ClassPathXmlApplicationContext("Beans.xml");
        EmployeeB e1 = a.getBean("e1",EmployeeB.class);
        System.out.println(e1);
    }
}
