package concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class MultiThreads {
	private static long sum = 0;
	private static long[] arr = new long[200000000];
	
	public static void main(String[] args) {
		
		//Create an array of 200 million random numbers between 1 - 10
		Random r = new Random();
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = 10 + r.nextInt((10 - 1) + 1);
			//System.out.println(arr[i]);
		}
		
		Instant startThread = Instant.now(); //Start time
		
		Thread t1 = new Thread(new Runnable() { // Create the first thread

			@Override
			public void run() {
				for(int i=0; i < 100000000; i++) {
					sum += arr[i]; //Compute the values in the array starting from 0 and ending at 100000000
				}
			}	
		});
		
		Thread t2 = new Thread(new Runnable() { //Create the second thread

			@Override
			public void run() {
				for(int i=100000000; i < 200000000; i++) {
					sum += arr[i]; // Compute the values in the array starting from 100000000 and ending at 200000000
				}
			}	
		});
		
		//stated threads
		t1.start();
		t2.start();
		
		try {
			t1.join(); // the join method will execute one thread at the time
			t2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Instant endThread = Instant.now(); //end time
		long timeSpent = Duration.between(startThread, endThread).toMillis();
		System.out.println("Multiple Thread Sum: " + sum + " in " + timeSpent + "ms");

	}

}
