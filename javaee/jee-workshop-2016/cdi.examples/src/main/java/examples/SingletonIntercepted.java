package examples;

import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;

@Singleton
public class SingletonIntercepted {

    private static final Logger LOGGER = Logger.getLogger(SingletonIntercepted.class);

    @Interceptors({ ProfilingInterceptor.class })
    public String sayHi() {
        LOGGER.info("Singleton instance: " + this);
        return "Hi from SingletonIntercepted bean!";
    }

}
