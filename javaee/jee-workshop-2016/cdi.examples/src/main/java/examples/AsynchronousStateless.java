package examples;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class AsynchronousStateless {

    private static final Logger LOGGER = Logger.getLogger(AsynchronousStateless.class);

    @Asynchronous
    public Future<String> sayHi() {
        LOGGER.info("Executing sayHi() in Asynchronous Stateless instance: " + this);
        sayHiAgain();
        return new AsyncResult<String>("Hi from AsynchronousStateless bean!");
    }

    @Asynchronous
    public void sayHiAgain() {
        LOGGER.info("Executing sayHiAgain() in Asynchronous Stateless instance: " + this);
    }

}
