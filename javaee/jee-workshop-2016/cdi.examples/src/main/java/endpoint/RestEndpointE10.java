package endpoint;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import examples.CreateSingleton;
import examples.CreateSingletonWithLocalBean;
import examples.CreateStateless;
import examples.LocalInterfaceForCreateSingleton;

@Path("")
public class RestEndpointE10 {

    @Inject
    private CreateSingleton                  singletonBean;

    @Inject
    private CreateStateless                  statelessBean;

    @Inject
    private LocalInterfaceForCreateSingleton singletonWithInterface;

    @Inject
    private CreateSingletonWithLocalBean     singletonLocalBean;

    @GET
    @Path("sayHiE10")
    @Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
    public String sayHi() {
        return singletonBean.sayHi() + '\n' + statelessBean.sayHi() + '\n' + singletonWithInterface.sayHi() + '\n' + singletonLocalBean.sayHi();
    }

}
