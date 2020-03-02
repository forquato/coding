import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Waiter {

    @Inject
    public Soup soup;

    public String orderSoup(String name){
        soup.setName(name);
        return soup.getName();
    }

    public String orderWhatTheOtherGuyHad() {
        String name = soup.getName();
        return name;
    }

    public Soup getSoup() {
        return soup;
    }
}
