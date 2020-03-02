package examples;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class StatelessWithState {

    private static final Logger LOGGER = Logger.getLogger(StatelessWithState.class);

    private int                 counter;

    public String sayHi() {
        counter++;

        LOGGER.info("StatelessWithState instance: " + this);
        LOGGER.info("Hi from CreateStateless bean! I see counter state: " + counter);

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Hi from CreateStateless bean! I see counter state: " + counter;
    }

}
