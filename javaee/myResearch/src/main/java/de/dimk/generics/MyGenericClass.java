package de.dimk.generics;


/*
* Die generische Klasse wird mit dem gewünschten Typ T paramentrisiert. Üblich sind T/E oder K/V für Key Value...
* */

public class MyGenericClass<T> {
    private T attribute;

    public void setAttribute(T attribute) {
        this.attribute = attribute;
    }

    public T getAttribute() {
        return attribute;
    }
}
