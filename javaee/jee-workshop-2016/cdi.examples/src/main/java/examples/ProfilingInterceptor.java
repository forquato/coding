package examples;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

public class ProfilingInterceptor {

    private static final Logger LOGGER = Logger.getLogger(ProfilingInterceptor.class);

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return ctx.proceed();
        } finally {
            LOGGER.info("Invocation of " + ctx.getMethod().getName() + " took " + (System.currentTimeMillis() - start) + "ms");
        }
    }

}
