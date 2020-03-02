package de.dimk.paramjunit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by korb009 on 18.05.2017.
 */

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {

    private Integer inputNumber;
    private Boolean exprectedResult;
    private PrimeNumberChecker primeNumberChecker;

    @Before
    public void initialize(){
        primeNumberChecker = new PrimeNumberChecker();
    }

    public PrimeNumberCheckerTest(Integer inputNumber, Boolean exprectedResult){
        this.inputNumber = inputNumber;
        this.exprectedResult = exprectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers(){
        return Arrays.asList(new Object[][]
                {{2,true},
                {6, false},
                {19, true},
                {22, false},
                {23,true}});
    }

    @Test
    public void testPrimeNumberChecker(){
        System.out.println("Parameterized Number is: " + inputNumber);

        assertEquals(exprectedResult, primeNumberChecker.validate(inputNumber));
    }
}
