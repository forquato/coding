package examples;

import javax.enterprise.context.ApplicationScoped;

import qualifier.EnglishHi;

@EnglishHi
@ApplicationScoped
public class EnglishHiSayer implements HiSayer {

    public String sayHi() {
        return "English: Hi from ApplicationScoped bean!";
    }

}
