package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowedTo(Visitor visitor) {
        Boolean canVisit = false;
        if(visitor.getAge() < 16){
            canVisit = true;
        }
        return canVisit;
    }
}
