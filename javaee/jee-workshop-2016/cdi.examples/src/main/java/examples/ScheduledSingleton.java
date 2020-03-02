package examples;

import javax.ejb.Singleton;

import org.apache.log4j.Logger;

@Singleton
public class ScheduledSingleton {

    private static final Logger LOGGER            = Logger.getLogger(ScheduledSingleton.class);

    private static final String EVERY_TEN_SECONDS = "*/10";

    private int                 executions;

    //@Schedule(second = EVERY_TEN_SECONDS, minute = "*", hour = "*", persistent = false)
    public void scheduled() {
        LOGGER.info("Scheduled execution triggered: " + this);
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        executions++;
        LOGGER.info("Scheduled execution finished: " + this);
    }

    public String sayHi() {
        LOGGER.info("Scheduled Singleton instance: " + this);
        return "Scheduled Singleton has performed " + executions + " scheduled executions.";
    }

}
