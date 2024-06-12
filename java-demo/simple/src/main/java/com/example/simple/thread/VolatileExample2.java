package com.example.simple.thread;


// Suppose we have a simple flag variable that controls whether a thread should stop running. 
// This flag is shared between two threads: one thread controls the flag, and the other thread performs some operations while monitoring this flag.

public class VolatileExample2 {

	private static boolean isRunning = true;
	
	public static void main(String[] args) throws InterruptedException {
		Thread volatileDemo = new Thread(() -> {
			System.out.println("Pring isRunning " + isRunning);
			
			int counter = 0;
			while (isRunning) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.err.println("Interrupted occred for the sleep");
				}
				System.out.println("Counter : " + counter ++);
			}
			
		});
		
		volatileDemo.join();
		
		volatileDemo.start();
		
		Thread.sleep(500);
		
		isRunning = false;
	}
	
}
