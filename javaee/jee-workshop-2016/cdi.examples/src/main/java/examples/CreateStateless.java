package examples;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class CreateStateless {

    private static final Logger LOGGER = Logger.getLogger(CreateStateless.class);

    public String sayHi() {
        LOGGER.info("Stateless instance: " + this);
        return "Hi from CreateStateless bean!";
    }

}
