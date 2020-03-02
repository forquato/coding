package examples;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;

@ApplicationScoped
public class AppScopedIntercepted {

    private static final Logger LOGGER = Logger.getLogger(AppScopedIntercepted.class);

    @Interceptors({ ProfilingInterceptor.class })
    public String sayHi() {
        LOGGER.info("AppScoped instance: " + this);
        return "Hi from ApplicationScoped Intercepted bean!";
    }

}
