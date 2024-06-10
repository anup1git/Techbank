package com.atos.fintect.thread;

public class VolatileExample {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            int count = 0;
            while (running) {
                count++;
                // Simulate some busy work
                try {
                    Thread.sleep(100); // Sleep for 100 milliseconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted, Failed to complete operation");
                }
            }
            System.out.println("Worker stopped after counting " + count);
        });

        worker.start();

        // Main thread sleeps for a bit and then stops the worker
        Thread.sleep(500); // Main thread sleeps for 500 milliseconds
        running = false;
        System.out.println("Main thread set the running flag to false.");
        worker.join(); // Wait for the worker thread to finish
    }
}
