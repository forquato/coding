package de.dimk.Thread.Runnable;


/*
 * www.callicoder.com
 *
 * See https://www.callicoder.com/java-multithreading-thread-and-runnable-tutorial/
 * and https://github.com/callicoder/java-concurrency-examples
 * */

public class RunnableExampleLambdaExpression {

    public static void main(String[] args) {

        System.out.println("Inside: " + Thread.currentThread().getName());

        System.out.println("Creating Runnable...");

        /*
        old style
        Runnable runable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside " + Thread.currentThread().getName() );
            }
        };
        */

        // lambda style
        Runnable runable = () -> System.out.println("Inside " + Thread.currentThread().getName());

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runable);

        System.out.println("Starting Thread...");
        thread.start();
    }

}
