import attractions.Playground;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.*;

public class ThemeParkTest {

    ThemePark themePark;
    Playground playground;
    TobaccoStall tobaccoStall;
    Visitor visitor;
    Visitor child;

    @Before
    public void setup(){
        themePark = new ThemePark("Jurassic Park");
        playground = new Playground("Banana", 5);
        tobaccoStall = new TobaccoStall("Davids Tobacco", "David", ParkingSpot.A1, 2);
        visitor = new Visitor(21, 190, 50);
    }

    @Test
    public void themeParkStartsWithEmptyListOfAttractions(){
        assertEquals(0, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddAttractionToThemePark(){
        themePark.add(playground);
        assertEquals(1, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddStallToThemePark(){
        themePark.add(tobaccoStall);
        assertEquals(1, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddStallsAndAttractionsToThemePark(){
        themePark.add(tobaccoStall);
        themePark.add(playground);
        assertEquals(2, themePark.getAllReviewed().size());
    }

    @Test
    public void visitorCanVisitAttraction(){
        themePark.visit(visitor, playground);
        assertEquals(1, playground.getVisitCount());
        assertEquals(1, visitor.getVisitedAttractions().size());
    }

    @Test
    public void themeParkCanStoreReviews(){
        themePark.add(playground);
        assertEquals((Integer) 5, themePark.getReviewedMap().get("Banana"));
        assertEquals(true, themePark.getReviewedMap().containsKey("Banana"));
    }

    @Test
    public void canSeeAllAllowedAttractionsForVisitor(){
        themePark.add(playground);
        themePark.add(tobaccoStall);
        child = new Visitor(10, 80, 10);
        assertEquals(1, themePark.getAllowedAttractions(child).size());

    }
}