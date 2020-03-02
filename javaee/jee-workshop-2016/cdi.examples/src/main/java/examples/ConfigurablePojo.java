package examples;

public class ConfigurablePojo implements HiSayer {

    private String whatToSay;

    public ConfigurablePojo(String whatToSay) {
        this.whatToSay = whatToSay;
    }

    public String sayHi() {
        return whatToSay;
    }

}
