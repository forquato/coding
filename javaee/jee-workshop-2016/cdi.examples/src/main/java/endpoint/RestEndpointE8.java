package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import examples.AppScopedIntercepted;

@Path("")
public class RestEndpointE8 {

    @Inject
    private AppScopedIntercepted appScope;

    @GET
    @Path("sayHiE8")
    public String sayHi() {
        return appScope.sayHi();
    }

}
