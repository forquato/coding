package de.dimk.lambda;

public class Person {

    private String name;
    private int age;
    private String clientTransactionId;

    public Person(String name, int age, String clientTransactionId) {
        this.name = name;
        this.age = age;
        this.clientTransactionId = clientTransactionId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClientTransactionId() {
        return clientTransactionId;
    }

    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    //gettersm setters, toString
}
