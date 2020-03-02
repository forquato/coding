package de.dimk.Thread.Runnable;

/*
* www.callicoder.com
*
* https://github.com/callicoder/java-concurrency-examples
* */

public class ThreadJoinExample {

    public static void main (String[] args) throws InterruptedException {

        // create Thread 1

        Runnable run1 = () -> {
            System.out.println("Entered Thread 1...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Exiting Thread 1");

        };

        Runnable run2 = () -> {

            System.out.println("Entered Thread 2...");

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e){
                throw new IllegalStateException(e);
            }

            System.out.println("Exiting Thread2");

        };

        System.out.println("Starting Thread1");
        Thread thread1 = new Thread(run1);
        thread1.start();

        System.out.println("Waiting for Thread1 to complete...");

        thread1.join(1000);

        System.out.println("Waited enough! Time to start Thread 2!");

        Thread thread2 = new Thread(run2);
        thread2.start();

    }

}
