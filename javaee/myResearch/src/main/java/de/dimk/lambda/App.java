package de.dimk.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30, "1"),
                new Person("jack", 20,"22"),
                new Person("lawrence", 40,"1")
        );

        List<String> listDistincta = persons.stream().map(Person::getClientTransactionId).distinct().collect(Collectors.toList());

        Supplier<LongStream> listDistinct = () -> persons.stream().mapToLong(m -> Long.parseLong(m.getClientTransactionId())).distinct();


        //listDistincta.forEach(System.out::println);



        System.out.println(listDistinct.get().count());


        listDistinct.get().forEach(System.out::println);

    }
}
