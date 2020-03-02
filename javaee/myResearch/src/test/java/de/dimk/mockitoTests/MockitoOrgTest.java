package de.dimk.mockitoTests;

import org.junit.Assert;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by korb009 on 16.05.2017.
 *
 * http://site.mockito.org/
 */
public class MockitoOrgTest {


    // VERIFY
    @Test
    public void verifyInteractionsOnList(){

        // mock creation

        // using mock object
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

        // verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    // stub method calls
    @Test
    public void methodCalls(){

        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(2));

        Assert.assertEquals("first",mockedList.get(0));


    }

}
