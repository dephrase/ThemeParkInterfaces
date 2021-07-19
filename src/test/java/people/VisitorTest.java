package people;

import attractions.Playground;
import org.junit.Before;
import org.junit.Test;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    Playground playground;
    TobaccoStall tobaccoStall;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        playground = new Playground("Banana", 5);
        tobaccoStall = new TobaccoStall("Davids Tobacco", "David", ParkingSpot.A1, 2);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void canAddStallsAndAttractionsToVisitorVisitedAttractions(){
        visitor.add(tobaccoStall);
        visitor.add(playground);
        assertEquals(2, visitor.getVisitedAttractions().size());
    }
}
