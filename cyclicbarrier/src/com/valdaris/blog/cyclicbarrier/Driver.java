package com.valdaris.blog.cyclicbarrier;

import java.util.Random;

/**
 * Driver of the race.
 * 
 * @author Javier Estevez (jestevez at valdaris.com)
 *
 */
public class Driver {

	private String name;
	private Double bestTime;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            name of the driver
	 * @param bestTime
	 *            the best time in a lap
	 */
	public Driver(String name, Double bestTime) {
		this.name = name;
		this.bestTime = bestTime;
	}

	public void drive() {
		System.out.println(name + " starts running!!");
		Double lapTime = getLapTime();
		try {
			Thread.sleep(Math.round(lapTime * 1000));
		} catch (InterruptedException e) {

		}
		System.out.println(name + " finished in " + lapTime + " seconds.");
		if (lapTime < bestTime) {
			System.out.println(name + " has beaten his best time!!");
			bestTime = lapTime;
		}
	}

	/**
	 * Calculates the lap time. It's randomly +-1 second around the best time.
	 * 
	 * @return lap time.
	 */
	private Double getLapTime() {
		Random r = new Random();
		return bestTime + r.nextDouble() * 2 - 1;
	}

	/**
	 * Returns the driver name.
	 * 
	 * @return driver name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the driver name.
	 * 
	 * @param name
	 *            driver name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the driver best lap time.
	 * 
	 * @return best lap time
	 */
	public Double getBestTime() {
		return bestTime;
	}

	/**
	 * Sets the driver best lap time.
	 * 
	 * @param bestTime
	 *            best lap time.
	 */
	public void setBestTime(Double bestTime) {
		this.bestTime = bestTime;
	}

}
