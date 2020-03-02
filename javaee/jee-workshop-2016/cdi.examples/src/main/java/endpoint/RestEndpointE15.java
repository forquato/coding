package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import examples.PooledStatelessWithTwoMethods;

@Path("")
public class RestEndpointE15 {

    @Inject
    private PooledStatelessWithTwoMethods statelessWithTwoMethods;

    @GET
    @Path("sayHiE15")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHiE11Singleton() {
        String sayHi = statelessWithTwoMethods.sayHi();

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return sayHi + '\n' + statelessWithTwoMethods.sayHiAgain();
    }
}
