package de.dimk.mockitoTests;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

/**
 * Created by korb009 on 16.05.2017.
 *
 * FROM https://gojko.net/2009/10/23/mockito-in-six-easy-examples/
 *
 */
public class gojkoNetMockitoTest {

    // stub method call
    @Test
    public void iterator_will_return_hello_world(){

        //arrange
        Iterator i=mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");

        //act
        String result = i.next() + " " + i.next();
        System.out.println(result);

        //assert
        assertEquals("Hello World", result);
    }

    // with a an specified argument
    @Test
    public void with_arguments(){
        // arrange
        Comparable c = mock(Comparable.class);
        when(c.compareTo("Test")).thenReturn(1);

        // assert
        System.out.println(c.compareTo("Test"));
        assertEquals(1,c.compareTo("Test"));
    }

    // with an uncpecified argument
    @Test
    public void with_uncpecified_arguments(){
        // arrange
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);

        //assert
        assertEquals(-1,c.compareTo(11));
    }


    // with void methods...
    @Test(expected = IOException.class)
    public void outputstreamwriter_throws_an_exception() throws IOException {
        //arrange
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);

        doThrow(new IOException()).when(mock).close();

        //this should throw IOException as expected
        osw.close();
    }

    // This example will verify that OutputStreamWriter propagates the close method call to the wrapped output stream.
    @Test
    public void outputstreamwriter_closes_on_close() throws IOException {

        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        osw.close();

        verify(mock).close();

    }




}
