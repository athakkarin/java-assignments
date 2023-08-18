package com.spring.Spring_Collecn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.StudentB;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext a = new ClassPathXmlApplicationContext("Beans.xml");
        
        StudentB sb = (StudentB) a.getBean("s1");
         
        System.out.println("List :-- " + sb.getList());
         
      
    }
}
