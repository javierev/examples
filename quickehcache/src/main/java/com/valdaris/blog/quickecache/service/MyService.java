package com.valdaris.blog.quickecache.service;

/**
 * This is just a dummy service to test Ecache.
 * 
 * @author Javier Estevez (jestevez@valdaris.com)
 *
 */
public interface MyService {
	
	/**
	 * Returns number of times the service's been 
	 * called since the bean has been created.
	 * 
	 * @return no of times.
	 */
	int timesCalled();

}
