package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import examples.Pojo;

@Path("")
public class RestEndpointE1 {

    @Inject
    private Pojo pojo;

    @GET
    @Path("sayHiE1")
    public String sayHi() {
        return pojo.sayHi();
    }

}
