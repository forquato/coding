package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import examples.StartupSingleton;

@Path("")
public class RestEndpointE16 {

    @Inject
    private StartupSingleton startupSingleton;

    @GET
    @Path("sayHiE16")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHiE11Singleton() {
        return startupSingleton.sayHi();
    }
}
