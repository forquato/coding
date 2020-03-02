package de.dimk.lambda.lambda_jenkovTuts;

import java.util.Comparator;

public class LambdaExamples {

    public static void main(String[] args) {

        //..............
        // Example 1
        //..............

        // implement standard interface comparator with an anynymous implememtation
        Comparator<String> stringComparator = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        int comparison = stringComparator.compare("hello", "world");

        System.out.println(comparison);

        // String o1 and o2 are parameters to the method which is to be implemented in an anonymous class
        // the body of the lambda expression after -> is the function with a return value. It's Equivalent to the Message Body of the anonymous implementation
        Comparator<String> stringComparatorLambda = (String o1, String o2) -> {
            return o1.compareTo(o2);
        };

        System.out.println(stringComparatorLambda.compare("hello", "world"));

        // we can also omit the return statement and simplify the lambda expression
        Comparator<String> stringComparatorLambda1 = (String o1, String o2) -> o1.compareTo(o2);

        System.out.println(stringComparatorLambda1.compare("hallo", "Welt"));

        //..............
        // Example 2
        //..............

        // When the're no parameters, then we can omit the parameters
        MyFunction myFunction = () -> System.out.println("This is my Apply test");

        myFunction.apply();

        //..............
        // Example 3
        //..............

        // In case of a single parameter, we can omit the parenthesis. Also we can use the java type inference
        MyFunctionWithPar myFunctionWithPar = o -> System.out.println(o);

        myFunctionWithPar.apply("This is my Text");

        //..............
        // Example 4
        //..............

        MyFunctionWithTwoPar myFunctionWithTwoPar = (o1,o2) -> System.out.println(o1 + " " + o2);
        myFunctionWithTwoPar.apply("Erster Textteil", "und zeiter Textteil.");

        //..............
        // Example 5
        //..............

        MyFunctionWithTwoParAndReturn myFunctionWithTwoParAndReturn = (o1,o2) -> o1+" and "+o2;

        String returnValue = myFunctionWithTwoParAndReturn.apply("first", "second");
        System.out.println(returnValue);

    }

}
