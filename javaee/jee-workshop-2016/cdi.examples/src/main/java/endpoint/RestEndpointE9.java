package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import examples.SingletonIntercepted;

@Path("")
public class RestEndpointE9 {

    @Inject
    private SingletonIntercepted appScope;

    @GET
    @Path("sayHiE9")
    public String sayHi() {
        return appScope.sayHi();
    }

}
