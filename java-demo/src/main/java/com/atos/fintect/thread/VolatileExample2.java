package com.atos.fintect.thread;


// Suppose we have a simple flag variable that controls whether a thread should stop running. 
// This flag is shared between two threads: one thread controls the flag, and the other thread performs some operations while monitoring this flag.

public class VolatileExample2 {

	private static volatile boolean isRunning = true;
	
	
	
}
