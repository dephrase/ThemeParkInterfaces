package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor child;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        child = new Visitor(8, 100, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void hasDefaultPrice(){
        assertEquals(4.50, dodgems.defaultPrice(), 0.00);
    }

    @Test
    public void chargeHalfForUnder12s(){
        assertEquals(2.25, dodgems.priceFor(child), 0.00);
    }
}
