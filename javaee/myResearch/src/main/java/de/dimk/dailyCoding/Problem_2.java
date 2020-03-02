package de.dimk.dailyCoding;

import java.util.Arrays;

public class Problem_2 {

   /* Given an array of integers, return a new array such that each element at index i of the new array is the product
    of all the numbers in the original array except the one at i.

    For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input
    was [3, 2, 1], the expected output would be [2, 3, 6].

    see also: https://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div
    */


   public static void myResult(){

       Integer[] figures = new Integer[] {1,2,3,4,5};
       Integer[] figuresResult = new Integer[figures.length];
/*
        int l = figures.length;
        while (l > 0){
            --l;
            System.out.println(figures[l]);
        }
*/
       for(int x=0; x < figures.length; x++){
           int  sum = 0;
           for (int u=0; u<figures.length; u++) {
               if (u != x){
                   if(sum !=0) {
                       sum = sum * figures[u];
                   } else {
                       sum = figures[u];
                   }
               }
           }
           figuresResult[x] = sum;
       }

       //Arrays.stream(figures).forEach(num -> System.out.println(num));

       Arrays.stream(figures).forEach(t -> System.out.print(t+" "));
       System.out.print("\n");
       Arrays.stream(figuresResult).forEach( t -> System.out.print(t + " "));

   }

   public static void resultStackOverFlow(){

      /*
       products_above: {              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }
       products_below: { a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }
       */

       Integer[] figures = new Integer[] {1,2,3,4,5};
       int p=1;

       int[] products_below = new int[5];

       for(int i=0;i<figures.length;++i) {
           products_below[i]=p;
           p*=figures[i];
       }

       //System.out.println("products below");
       //Arrays.stream(products_below).forEach(t -> System.out.println(t + " "));

       int[] products_above = new int[5];
       p=1;
       for(int i=figures.length-1;i>=0;--i) {
           products_above[i]=p;
           p*=figures[i];
       }

       int[] products = new int[5]; // This is the result
       for(int i=0;i<figures.length;++i) {
           products[i]=products_below[i]*products_above[i];
       }

       System.out.println("\n");
       Arrays.stream(products).forEach(t -> System.out.print(t + " "));
   }

    public static void main(String args[]){


       myResult();
       //resultStackOverFlow();

    }

}
