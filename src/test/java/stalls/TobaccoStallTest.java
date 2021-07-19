package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor eighteen;
    Visitor seventeen;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 3);
        eighteen = new Visitor(18, 160, 20);
        seventeen = new Visitor(17, 160, 20);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void eighteenYearOldCanAttend(){
        assertEquals(true, tobaccoStall.isAllowedTo(eighteen));
    }

    @Test
    public void underEighteenCantAttend(){
        assertEquals(false, tobaccoStall.isAllowedTo(seventeen));
    }
}
