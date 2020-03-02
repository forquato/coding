package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import examples.TheadSafeApplicationScoped;
import examples.TheadSafeSingleton;

@Path("")
public class RestEndpointE11_14 {

    @Inject
    private TheadSafeApplicationScoped tsAppScoped;

    @Inject
    private TheadSafeSingleton         tsSingleton;

    @GET
    @Path("sayHiE11Singleton")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHiE11Singleton() {
        return tsSingleton.sayHi();
    }

    @GET
    @Path("sayHiE11AppScoped")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHiE11AppScoped() {
        return tsAppScoped.sayHi();
    }

}
