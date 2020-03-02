package de.dimk.generics;

public class MyGenericClassTest {

    public static void main(String[] args){

        MyGenericClass<String> myGenericClass = new MyGenericClass<>();
        myGenericClass.setAttribute("This is my String in my generic Class!");

        System.out.println(myGenericClass.getAttribute());
    }

}


