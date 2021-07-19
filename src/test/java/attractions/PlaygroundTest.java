package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor youngAdult;
    Visitor fifteen;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        youngAdult = new Visitor(16, 180, 15);
        fifteen = new Visitor(15, 160, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void childrenOver15CantVisit(){
        assertEquals(false, playground.isAllowedTo(youngAdult));
    }

    @Test
    public void fifteenYearOldCanVisit(){
        assertEquals(true, playground.isAllowedTo(fifteen));
    }

    @Test
    public void canGetRating(){
        assertEquals(7, playground.getRating());
    }

    @Test
    public void canGetName(){
        assertEquals("Fun Zone", playground.getName());
    }
}
