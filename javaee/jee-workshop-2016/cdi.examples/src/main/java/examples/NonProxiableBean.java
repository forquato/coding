package examples;

//No annotation here. In CDI this equals to @Dependent
public class NonProxiableBean {

    public String sayHi() {
        return "Hi from nonproxyable bean!";
    }

}
