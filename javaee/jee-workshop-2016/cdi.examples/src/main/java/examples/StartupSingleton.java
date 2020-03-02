package examples;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

@Startup
@Singleton
public class StartupSingleton {

    private static final Logger LOGGER = Logger.getLogger(StartupSingleton.class);

    @PostConstruct
    public void init() {
        LOGGER.info("STARTUP SINGELTON IS INITIALIZING: " + this);
    }

    public String sayHi() {
        LOGGER.info("Singleton instance: " + this);
        return "Hi from StartupSingleton bean!";
    }

}
