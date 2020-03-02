package endpoint;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import examples.AsynchronousStateless;

@Path("")
public class RestEndpointE18 {

    private static final Logger   LOGGER = Logger.getLogger(RestEndpointE18.class);

    @Inject
    private AsynchronousStateless asyncStateless;

    @GET
    @Path("sayHiE18")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHi() {
        LOGGER.info("Executing REST Endpont instance: " + this);
        try {
            return asyncStateless.sayHi().get();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        }
    }
}
