package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import examples.StatelessWithState;

@Path("")
public class RestEndpointE13 {

    @Inject
    private StatelessWithState statelessWithState;

    @GET
    @Path("sayHiE13")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHiE11Singleton() {
        return statelessWithState.sayHi();
    }
}
