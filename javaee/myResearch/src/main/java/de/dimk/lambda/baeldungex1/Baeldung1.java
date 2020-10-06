package de.dimk.lambda.baeldungex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Baeldung1 {


    public static void main (String args[]) {

        Stream<String> empty = Stream.empty();

        streamColl();

        filterStream();

    }





    // Its often the case that the empty() method is used upon creation to avoid returning null for streams with no element:
    public Stream<String> streamOf(List<String> list){
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    private static void streamColl(){

        Collection<String> stringCollection = Arrays.asList("a", "b", "c", "d");

        Stream<String> stringStream = stringCollection.stream();

        System.out.println(stringStream.count());

    }



    private static void filterStream() {

        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");

        boolean istExisting = list.stream().anyMatch( x -> x.contains("d"));

        System.out.println(istExisting);

        // The filter() method allows us to pick stream of elements which satisfy a predicate.
        Stream<String> stringStream = list.stream().filter(element -> element.contains("d"));
        stringStream.forEach(System.out::println);

        // To convert elements of a Stream by applying a special function to them and to collect
        // these new elements into a Stream, we can use the map() method:
        List<String> uppercase = list.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        uppercase.stream().forEach(x -> System.out.println(x));


    }

}
