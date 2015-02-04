package com.valdaris.blog.quickecache.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.valdaris.blog.quickecache.service.MyService;

/**
 * This is just a dummy service to test Ecache.
 * 
 * @author Javier Estevez (jestevez@valdaris.com)
 *
 */
@Service("myService")
public class MyServiceImpl implements MyService {
	
	private int count = 0;
	
	/**
	 * {@inheritDoc}
	 */
	@Cacheable(value="myCache")
	public int timesCalled() {
		return ++count;
	}

}
