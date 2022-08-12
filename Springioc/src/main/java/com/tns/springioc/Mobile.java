package com.tns.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile 
{

	public static void main(String[] args) 
	{
		ApplicationContext c = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("congif loaded..!");
		//Airtel a = (Airtel)c.getBean("airtel");
		
		Jio j = c.getBean("jio",Jio.class);
		j.calling();
		j.data();
		
	    
		
		
		

	}

}
