package config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import examples.ConfigurablePojo;
import examples.HiSayer;
import qualifier.GermanHi;
import qualifier.SpanishHi;

@ApplicationPath("")
public class ApplicationConfig extends Application {

    /**
     * - flexible bean initialization mechanism
     * - Producers may be used to create - or produce - bean instance to be consumed by an application.
     * - they are a valid way to support polymorphism in a CDI application
     *
     * - Producers are also useful to encapsulate bean initialization or even to enable injection of
     * object instances that are not themselves CDI managed beans into some points of our application.
     *
     */


    @Produces
    @ApplicationScoped
    public HiSayer createNonBeanPojo() {
        return new ConfigurablePojo("Hi from Configurable POJO!");
    }

    /**
     * German and Spanish Hi: We may change the Producer method in order to support the Polymorphism:
     * We may also use qualifiers in order to support polymorphism. Let's see the MessageTransportType enum we used in the previous section:.
     */


    @Produces
    @GermanHi
    @ApplicationScoped
    public HiSayer createGermanHi() {
        return new ConfigurablePojo("German: Hallo von Configurable POJO!");
    }

    /**
     * The method createSpanishHi() is annotated with @Produces so the CDI container will know
     * it produces a HiSayer-Implementation. Now we may inject HiSayer implementations
     * into our application.
     *
     */

    @Produces
    @SpanishHi
    @ApplicationScoped
    public HiSayer createSpanishHi() {
        return new ConfigurablePojo("Spanish: Configurable POJO dice hola!");
    }

}
