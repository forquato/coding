package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

import examples.AppScoped;

@Path("")
public class RestEndpointE2 {

    private static final Logger LOGGER = Logger.getLogger(RestEndpointE2.class);

    @Inject
    private AppScoped           appScope;

    @GET
    @Path("sayHiE2")
    public String sayHi() {
        LOGGER.info("Injected AppScope instance: " + appScope.getClass().toString());
        return appScope.sayHi();
    }

}
