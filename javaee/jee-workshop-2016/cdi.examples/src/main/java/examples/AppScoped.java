package examples;

import javax.enterprise.context.ApplicationScoped;

import org.apache.log4j.Logger;

@ApplicationScoped
public class AppScoped {

    private static final Logger LOGGER = Logger.getLogger(AppScoped.class);

    public String sayHi() {
        LOGGER.info("AppScoped instance: " + this);
        return "Hi from ApplicationScoped bean!";
    }

}
