package domains.farmer;

import framework.problem.Mover;
import framework.problem.State;
/**
 *
 * @author Ryan Cahoon
 * @section 1
 */
public class FarmerMover extends Mover {
    public static final String goesAlone = "Farmer Goes Alone";
    public static final String takesWolf = "Farmer Takes Wolf";
    public static final String takesGoat = "Farmer Takes Goat";
    public static final String takesCabbage = "Farmer Takes Cabbage";

    public FarmerMover() {
        super.addMove(goesAlone, s -> goesAlone(s));
        super.addMove(takesWolf, s -> takesWolf(s));
        super.addMove(takesGoat, s -> takesGoat(s));
        super.addMove(takesCabbage, s -> takesCabbage(s));
    }

    private State goesAlone(State state) {
        FarmerState FS = (FarmerState) state;
        String direction = "";
        if(FS.getWolf().equals(FS.getGoat())|| FS.getGoat().equals(FS.getCabbage()))
            //return FS;
            return null;
        else {
            //assign farmer
            if (FS.getFarmer() == "West")
                direction = "East";
            else if (FS.getFarmer() == "East")
                direction = "West";
            return new FarmerState(direction, FS.getWolf(), FS.getGoat(), FS.getCabbage());
        }
    }

    private State takesWolf(State state) {
        FarmerState FS = (FarmerState) state;
        String Fdirection = "";
        String Wdirection = "";
        if(FS.getGoat().equals(FS.getCabbage()) || FS.getFarmer() != FS.getWolf())
            return null;
        else {
            //assign farmer
            if (FS.getFarmer() == "West")
                Fdirection = "East";
            else if (FS.getFarmer() == "East")
                Fdirection = "West";
            //assign wolf
            if (FS.getWolf() == "West")
                Wdirection = "East";
            else if (FS.getWolf() == "East")
                Wdirection = "West";
            return new FarmerState(Fdirection, Wdirection, FS.getGoat(), FS.getCabbage());
        }
    }

    private State takesGoat(State state) {
        FarmerState FS = (FarmerState) state;
        String Fdirection = "";
        String Gdirection = "";
        if(FS.getFarmer() != FS.getGoat())
            return null;
        else {
            //assign both
            if (FS.getFarmer() == "West") {
                Fdirection = "East";
                Gdirection = "East";
            }
            else if (FS.getFarmer() == "East") {
                Fdirection = "West";
                Gdirection = "West";
            }
            return new FarmerState(Fdirection, FS.getWolf(), Gdirection, FS.getCabbage());
        }
    }

    private State takesCabbage(State state) {
        FarmerState FS = (FarmerState) state;
        String Fdirection = "";
        String Cdirection = "";
        if(FS.getGoat().equals(FS.getWolf()) || FS.getFarmer() != FS.getCabbage())
            //return FS;
            return null;
        else {
            //assign farmer
            if (FS.getFarmer() == "West")
                Fdirection = "East";
            else if (FS.getFarmer() == "East")
                Fdirection = "West";
            //assign cabbage
            if (FS.getCabbage() == "West")
                Cdirection = "East";
            else if (FS.getCabbage() == "East")
                Cdirection = "West";
            return new FarmerState(Fdirection, FS.getWolf(), FS.getGoat(), Cdirection);
        }
    }
}
