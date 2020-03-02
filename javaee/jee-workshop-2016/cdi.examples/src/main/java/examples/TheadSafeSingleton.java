package examples;

import javax.ejb.Singleton;

import org.apache.log4j.Logger;

@Singleton
public class TheadSafeSingleton {

    private static final Logger LOGGER = Logger.getLogger(TheadSafeSingleton.class);

    public String sayHi() {
        LOGGER.info("TheadSafeSingleton instance: " + this);
        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LOGGER.info("TheadSafeSingleton instance after sleep: " + this);
        return "Hi from TheadSafeSingleton bean!";
    }

}
