import org.jboss.weld.context.ejb.Ejb;
import org.jglue.cdiunit.CdiRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static com.google.common.base.CharMatcher.isNot;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(CdiRunner.class)
public class RestaurantTest {

    private static String TOMATO_SOUP = "Tomato Soup";

    @Inject
    private Waiter joe;
    @Inject
    private Waiter andi;

    @Test
    public void orderSoup(){
        String someSoup = joe.orderSoup(TOMATO_SOUP);
        assertEquals(TOMATO_SOUP, someSoup);

        String sameSoup = joe.orderWhatTheOtherGuyHad();
        assertEquals(TOMATO_SOUP, sameSoup);

        String someSoup1 = andi.getSoup().getName();
        assertEquals(TOMATO_SOUP, someSoup1);
    }

    @Test
    public void andiSoup(){
        String someSoup = andi.getSoup().getName();
        assertThat(TOMATO_SOUP, is(not(someSoup)));
    }

}
