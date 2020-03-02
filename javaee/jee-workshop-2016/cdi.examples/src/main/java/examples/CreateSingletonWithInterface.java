package examples;

import javax.ejb.Singleton;

import org.apache.log4j.Logger;

@Singleton
public class CreateSingletonWithInterface implements LocalInterfaceForCreateSingleton {

    private static final Logger LOGGER = Logger.getLogger(CreateSingletonWithInterface.class);

    public String sayHi() {
        LOGGER.info("Singleton instance: " + this);
        return "Hi from CreateSingletonWithInterface bean!";
    }
}
