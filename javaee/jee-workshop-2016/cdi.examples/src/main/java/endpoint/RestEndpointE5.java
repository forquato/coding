package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import examples.HiSayer;

@Path("")
public class RestEndpointE5 {

    @Inject
    private HiSayer nonBeanPojo;

    @GET
    @Path("sayHiE5")
    public String sayHi() {
        return nonBeanPojo.sayHi();
    }

}
