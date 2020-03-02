package examples;

import javax.enterprise.context.ApplicationScoped;

import qualifier.BulgarianHi;

@BulgarianHi
@ApplicationScoped
public class BulgarianHiSayer implements HiSayer {

    public String sayHi() {
        return "Bulgarian: Здрасти от ApplicationScoped bean!";
    }

}
