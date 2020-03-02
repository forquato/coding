package examples;

import javax.ejb.Singleton;

import org.apache.log4j.Logger;

@Singleton
public class CreateSingleton {

    private static final Logger LOGGER = Logger.getLogger(CreateSingleton.class);

    public String sayHi() {
        LOGGER.info("Singleton instance: " + this);
        return "Hi from CreateSingleton bean!";
    }

}
