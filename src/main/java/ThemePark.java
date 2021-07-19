import attractions.Attraction;
import attractions.Playground;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ThemePark {

    String name;
    ArrayList<IReviewed> moneyMakers;

    public ThemePark(String name){
        this.name = name;
        this.moneyMakers = new ArrayList<>();
    }

    public ArrayList<IReviewed> getAllReviewed(){
        return moneyMakers;
    }

    public void add(IReviewed ireview) {
        this.moneyMakers.add(ireview);
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.incrementVisit();
        visitor.add(attraction);
    }


    public HashMap<String, Integer> getReviewedMap() {
        HashMap<String, Integer> moneyMakersMap = new HashMap<>();

        for(IReviewed ireview : moneyMakers){
            moneyMakersMap.put(ireview.getName(), ireview.getRating());
        }
        return moneyMakersMap;
    }

    public ArrayList<IReviewed> getAllowedAttractions(Visitor child) {
        ArrayList<IReviewed> allowableRides = new ArrayList<>();
        for(IReviewed ireview: moneyMakers){
            if(ireview instanceof ISecurity){
                if(((ISecurity) ireview).isAllowedTo(child)){
                    allowableRides.add(ireview);
                }
            } else {
                allowableRides.add(ireview);
            }
        }
        return allowableRides;
    }
}
