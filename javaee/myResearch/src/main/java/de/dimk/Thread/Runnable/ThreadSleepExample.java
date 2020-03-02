package de.dimk.Thread.Runnable;


/*
* www.callicoder.com
*
* https://github.com/callicoder/java-concurrency-examples
*
* */

public class ThreadSleepExample {

    public static void main(String[] args) {

        System.out.println("Inside : " + Thread.currentThread().getName());

        String[] messages = {"1", "2", "3", "4", "5", "6"};

        Runnable runnable = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());

            for (String message : messages) {
                System.out.println(message);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }


            }

        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

}
