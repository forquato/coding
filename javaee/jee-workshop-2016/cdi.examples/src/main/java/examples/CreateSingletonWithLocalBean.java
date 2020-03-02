package examples;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import org.apache.log4j.Logger;

@Singleton
@LocalBean
public class CreateSingletonWithLocalBean implements InterfaceForSingletonLocanBean {

    private static final Logger LOGGER = Logger.getLogger(CreateSingletonWithLocalBean.class);

    /* (non-Javadoc)
     * @see examples.InterfaceForSingletonLocanBean#sayHi()
     */
    public String sayHi() {
        LOGGER.info("Singleton instance: " + this);
        return "Hi from CreateSingletonWithLocalBean bean!";
    }

}
