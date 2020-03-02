package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import examples.CannotBeProxiedBean;
import examples.NonProxiableBean;
import examples.ProxiableBean;

@Path("")
public class RestEndpointE3 {

    @Inject
    private NonProxiableBean    nonProxiableBean;

    @Inject
    private ProxiableBean       proxiableBean;

    @Inject
    private CannotBeProxiedBean cannotBeProxiedBean;

    @GET
    @Path("sayHiE3")
    public String sayHi() {
        return cannotBeProxiedBean.sayHi();
    }

}
