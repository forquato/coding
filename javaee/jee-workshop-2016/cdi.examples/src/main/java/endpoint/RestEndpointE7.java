package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import examples.HiSayer;
import qualifier.GermanHi;
import qualifier.SpanishHi;

@Path("")
public class RestEndpointE7 {

    @Inject
    @GermanHi
    private HiSayer germanHi;

    @Inject
    @SpanishHi
    private HiSayer spanishHi;

    @GET
    @Path("sayHiE7")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHi() {
        return spanishHi.sayHi() + '\n' + germanHi.sayHi();
    }

}
