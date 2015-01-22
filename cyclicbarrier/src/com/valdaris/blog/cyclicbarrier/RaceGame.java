/*
 *   Coding examples - CyclicBarrier (The Race Game Example)
 *   Copyright (C) 2014  Javier Estevez
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Lesser General Public License by
 *   the Free Software Foundation, either version 3 of the License.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.valdaris.blog.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * {@CyclicBarrier} example. Full explanation in
 * http://blog.valdaris.com/post/how-to-use-cyclicbarrier/
 * 
 * @author Javier Estevez (jestevez at valdaris.com)
 *
 */
public class RaceGame {

	private static String[] DRIVER_NAMES = { "Ayrton", "Michael", "Niki" };

	private static Double[] BEST_TIMES = { 13.21, 13.03, 13.25 };

	public static void main(String[] args) throws InterruptedException {

		final CyclicBarrier semaphore = new CyclicBarrier(DRIVER_NAMES.length);
		
		//Driver instantiation
		for (int i = 0; i < DRIVER_NAMES.length; i++) {
			final Driver driver = new Driver(DRIVER_NAMES[i], BEST_TIMES[i]);
			Thread t = new Thread() {
				public void run() {
					System.out.println(driver.getName() + " is ready.");
					try {
						//Driver waits to semaphore to get read to drive
						semaphore.await();
						driver.drive();
					} catch (InterruptedException | BrokenBarrierException e) {
					}
				}
			};
			t.start();
			//In order to see the example, every driver gets to the starting line
			//2.5 seconds after the last one.
			Thread.sleep(2500);
		}

	}

}
