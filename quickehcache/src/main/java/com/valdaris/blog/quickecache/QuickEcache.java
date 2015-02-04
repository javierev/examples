package com.valdaris.blog.quickecache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valdaris.blog.quickecache.service.MyService;

public class QuickEcache {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		MyService myService = context.getBean(MyService.class);
		
		System.out.println("Times called: " + myService.timesCalled());
		System.out.println("Times called: " + myService.timesCalled());
		System.out.println("Times called: " + myService.timesCalled());
		System.out.println("Times called: " + myService.timesCalled());
		System.out.println("Times called: " + myService.timesCalled());
		
		
	}

}
