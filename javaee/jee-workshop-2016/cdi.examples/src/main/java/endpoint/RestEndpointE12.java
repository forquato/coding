package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import examples.TheadSafeApplicationScoped;
import examples.TheadSafeReadSingleton;

@Path("")
public class RestEndpointE12 {

    @Inject
    private TheadSafeApplicationScoped tsAppScoped;

    @Inject
    private TheadSafeReadSingleton     tsReadSingleton;

    @GET
    @Path("sayHiE12Singleton")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHiE11Singleton() {
        return tsReadSingleton.sayHi();
    }

    @GET
    @Path("sayHiE12AppScoped")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHiE11AppScoped() {
        return tsAppScoped.sayHi();
    }

}
