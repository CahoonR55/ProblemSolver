package domains.farmer;

import framework.problem.State;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Ryan Cahoon
 * @term 1
 */
public class FarmerState implements State {
    public FarmerState(String f, String w, String g, String c) {

        this.farmer = f;
        this.wolf = w;
        this.goat = g;
        this.cabbage = c;
    }
    @Override
    public int hashCode() {
        int hash = String.CASE_INSENSITIVE_ORDER.hashCode();
        return hash;
    }


    @Override
    public boolean equals(Object other) {
        boolean isEqual = true;

        if(other != null) {
            FarmerState otherFarmer = (FarmerState) other;
            if(getFarmer() != otherFarmer.getFarmer() || getWolf() != otherFarmer.getWolf())
                isEqual = false;
            if(getGoat() != otherFarmer.getGoat() || getCabbage() != otherFarmer.getCabbage())
                isEqual = false;
        }
        else if(other == null) {
            isEqual = false;
            throw new java.lang.NullPointerException();
        }
        return isEqual;
    }

    @Override
    public String toString() {
        String state = "   |  |   \n";
        //add farmer
        if(getFarmer() == "West")
            state = state.concat(" F |  |   \n");
        else if(getFarmer() == "East")
            state = state.concat("   |  | F \n");

        //add wolf
        if(getWolf() == "West")
            state = state.concat(" W |  |   \n");
        else if(getWolf() == "East")
            state = state.concat("   |  | W \n");

        //add goat
        if(getGoat() == "West")
            state = state.concat(" G |  |   \n");
        else if(getGoat() == "East")
            state = state.concat("   |  | G \n");

        //add cabbage
        if(getCabbage() == "West")
            state = state.concat(" C |  |   \n");
        else if(getCabbage() == "East")
            state = state.concat("   |  | C \n");
        state = state.concat("   |  |   ");

        return state;
    }

    public String getFarmer() {
        return farmer;
    }

    public String getWolf() {
        return wolf;
    }

    public String getGoat() {
        return goat;
    }

    public String getCabbage() {
        return cabbage;
    }


    private String farmer;
    private String wolf;
    private String goat;
    private String cabbage;
    private static final String NEW_LINE = "\n";

}
