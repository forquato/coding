package examples;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProxiableBean {

    public String sayHi() {
        return "Hi from proxyable bean!";
    }

}
