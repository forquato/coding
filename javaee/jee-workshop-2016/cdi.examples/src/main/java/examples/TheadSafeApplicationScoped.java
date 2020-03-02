package examples;

import javax.enterprise.context.ApplicationScoped;

import org.apache.log4j.Logger;

@ApplicationScoped
public class TheadSafeApplicationScoped {

    private static final Logger LOGGER = Logger.getLogger(TheadSafeApplicationScoped.class);

    public String sayHi() {
        LOGGER.info("TheadSafeApplicationScoped instance: " + this);
        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LOGGER.info("TheadSafeApplicationScoped instance after sleep: " + this);
        return "Hi from TheadSafeApplicationScoped bean!";
    }

}
