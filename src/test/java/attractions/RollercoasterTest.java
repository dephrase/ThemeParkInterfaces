package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;
    Visitor meetsCriteria;
    Visitor tooSmall;
    Visitor twelve;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor = new Visitor(18, 205, 10);
        meetsCriteria = new Visitor(13, 146, 10);
        tooSmall = new Visitor(13, 140, 10);
        twelve = new Visitor(12, 150, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void hasDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.00);
    }

    @Test
    public void chargeDoubleForTallFolk(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.00);
    }

    @Test
    public void personOver145cmAnd12YearsOldCanRide(){
        assertEquals(true, rollerCoaster.isAllowedTo(meetsCriteria));
    }

    @Test
    public void personUnder145CanRide(){
        assertEquals(false, rollerCoaster.isAllowedTo(tooSmall));
    }

    @Test
    public void twelveYearOldIsTooYoungToRide(){
        assertEquals(false, rollerCoaster.isAllowedTo(twelve));
    }
}
