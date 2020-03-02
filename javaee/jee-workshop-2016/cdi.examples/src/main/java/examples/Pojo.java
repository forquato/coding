package examples;

import org.apache.log4j.Logger;

public class Pojo {

    private static final Logger LOGGER = Logger.getLogger(Pojo.class);

    public String sayHi() {
        LOGGER.info("Pojo instance: " + this);
        return "Hi from POJO!";
    }

}
