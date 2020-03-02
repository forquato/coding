package examples;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class PooledStatelessWithTwoMethods {

    private static final Logger LOGGER = Logger.getLogger(PooledStatelessWithTwoMethods.class);

    public String sayHi() {
        LOGGER.info("Called sayHi() in Stateless instance: " + this);

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        LOGGER.info("Leaving sayHi() in Stateless instance: " + this);

        return "Hi from PooledStatelessWithTwoMethods bean!";
    }

    public String sayHiAgain() {
        LOGGER.info("Called sayHiAgain() in Stateless instance: " + this);

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        LOGGER.info("Leaving sayHiAgain() in Stateless instance: " + this);

        return "Hi Again from PooledStatelessWithTwoMethods bean!";
    }

}
