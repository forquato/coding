package examples;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

@ApplicationScoped
public class LifecycleAppScopeBean {

    private static final Logger     LOGGER = Logger.getLogger(LifecycleAppScopeBean.class);

    @Inject
    private LifecycleDependencyBean dependency;

    public LifecycleAppScopeBean() {
        LOGGER.info("ctor; Instance: " + this + " Dependency: " + dependency);
    }

    @PostConstruct
    public void init() {
        LOGGER.info("PostConstruct; Instance: " + this + " Dependency: " + dependency);
    }

    @PreDestroy
    public void preDestr() {
        LOGGER.info("PreDestroy; Instance: " + this + " Dependency: " + dependency);
    }

    public String sayHi() {
        LOGGER.info("sayHi(); Instance: " + this + " Dependency: " + dependency);
        return "Hi from LifecycleAppScopeBean bean!";
    }

}
