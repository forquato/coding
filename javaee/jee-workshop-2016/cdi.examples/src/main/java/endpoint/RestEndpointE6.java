package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import examples.HiSayer;
import qualifier.BulgarianHi;
import qualifier.EnglishHi;

@Path("")
public class RestEndpointE6 {

    @Inject
    @BulgarianHi
    private HiSayer bulgarianHi;

    @Inject
    @EnglishHi
    private HiSayer englishHi;

    @GET
    @Path("sayHiE6")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHi() {
        return englishHi.sayHi() + '\n' + bulgarianHi.sayHi();
    }

}
