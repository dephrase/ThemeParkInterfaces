package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements ITicketed, ISecurity {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPrice() {
        return 8.40;
    }

    @Override
    public double priceFor(Visitor visitor) {
        double price = defaultPrice();
        if(visitor.getHeight() > 200){
            price *= 2;
        }
        return price;
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        Boolean canRide = false;
        if(visitor.getAge() > 12 && visitor.getHeight() > 145){
            canRide = true;
        }
        return canRide;
    }
}
