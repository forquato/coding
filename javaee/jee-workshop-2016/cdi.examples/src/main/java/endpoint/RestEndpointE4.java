package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import examples.LifecycleAppScopeBean;
import examples.LifecycleDependentBean;

@Path("")
public class RestEndpointE4 {

    @Inject
    private LifecycleAppScopeBean  appScoped;

    @Inject
    private LifecycleDependentBean dependent;

    @GET
    @Path("sayHiE4")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHi() {
        return appScoped.sayHi() + '\n' + dependent.sayHi();
    }

}
