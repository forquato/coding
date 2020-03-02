package examples;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;

import org.apache.log4j.Logger;

@Dependent
public class LifecycleDependencyBean {

    private static final Logger LOGGER = Logger.getLogger(LifecycleDependencyBean.class);

    public LifecycleDependencyBean() {
        LOGGER.info("ctor; Instance: " + this);
    }

    @PostConstruct
    public void init() {
        LOGGER.info("PostConstruct; Instance: " + this);
    }

    @PreDestroy
    public void preDestr() {
        LOGGER.info("PreDestroy; Instance: " + this);
    }

}
