package examples;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import org.apache.log4j.Logger;

@Singleton
//Default: @Lock(LockType.WRITE)
public class TheadSafeReadSingleton {

    private static final Logger LOGGER = Logger.getLogger(TheadSafeReadSingleton.class);

    @Lock(LockType.READ)
    public String sayHi() {
        LOGGER.info("TheadSafeReadSingleton instance: " + this);
        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LOGGER.info("TheadSafeReadSingleton instance after sleep: " + this);
        return "Hi from TheadSafeReadSingleton bean!";
    }

}
