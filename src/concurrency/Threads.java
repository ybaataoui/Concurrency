package concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

class SingleThread extends Thread{
	private static long sum = 0;
	private static long[] arr = new long[200000000]; // initialize an array of 200000000 numbers
	
	@Override
	public void run() {
		
		//Grenerate 
		//randomNum = minimum + rand.nextInt((maximum - minimum) + 1);
		Random r = new Random();
		for(int i=0; i < arr.length; i++) {
			arr[i] = 10 + r.nextInt((10 - 1) + 1);
			//System.out.println(arr[i]);

		}
		
		Instant startThread = Instant.now(); // start time
		
		for(int i=0; i < arr.length; i++) {
			sum += arr[i]; // compute the array values
		}
		
		Instant endThread = Instant.now(); //end time
		
		long timeSpent = Duration.between(startThread, endThread).toMillis(); // 
		System.out.println("Single Thread Sum: " + sum + " in " + timeSpent + "ms");
		
	}
		
}


public class Threads  {
	
	public static void main(String[] args) {
		SingleThread st = new SingleThread();
		st.start();	
	}

}
