package de.dimk.paramjunit;

/**
 * Created by korb009 on 18.05.2017.
 */
public class PrimeNumberChecker {

    public Boolean validate(final Integer primeNumber){
        for (int i =2; i < (primeNumber/2); i++){
            if(primeNumber % i == 0){
                return false;
            }
        }
        return true;
    }

}
