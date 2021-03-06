package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;
import java.util.Arrays;
/**
 *
 * @author Ryan Cahoon
 * @section 1
 */
public class PuzzleMover extends Mover {
    public static final String s1 = "SLIDE TILE 1";
    public static final String s2 = "SLIDE TILE 2";
    public static final String s3 = "SLIDE TILE 3";
    public static final String s4 = "SLIDE TILE 4";
    public static final String s5 = "SLIDE TILE 5";
    public static final String s6 = "SLIDE TILE 6";
    public static final String s7 = "SLIDE TILE 7";
    public static final String s8 = "SLIDE TILE 8";

    public PuzzleMover() {
        super.addMove(s1, s -> slide1(s));
        super.addMove(s2, s -> slide2(s));
        super.addMove(s3, s -> slide3(s));
        super.addMove(s4, s -> slide4(s));
        super.addMove(s5, s -> slide5(s));
        super.addMove(s6, s -> slide6(s));
        super.addMove(s7, s -> slide7(s));
        super.addMove(s8, s -> slide8(s));
    }

    private State slide1(State state) {
        PuzzleState PS = (PuzzleState) state;
        int t1R = PS.getLocation(1).getRow();
        int t1C = PS.getLocation(1).getColumn();
        int t0R = PS.getLocation(0).getRow();
        int t0C = PS.getLocation(0).getColumn();

        if(((t1R == t0R) && (t1C == t0C+1 || t1C == t0C-1)) || ((t1C == t0C) && (t1R == t0R+1 || t1R == t0R-1)))
            return new PuzzleState(PS, PS.getLocation(1), PS.getLocation(0));
        else
            return null;
    }

    private State slide2(State state) {
        PuzzleState PS = (PuzzleState) state;
        int t1R = PS.getLocation(2).getRow();
        int t1C = PS.getLocation(2).getColumn();
        int t0R = PS.getLocation(0).getRow();
        int t0C = PS.getLocation(0).getColumn();

        if(((t1R == t0R) && (t1C == t0C+1 || t1C == t0C-1)) || ((t1C == t0C) && (t1R == t0R+1 || t1R == t0R-1)))
            return new PuzzleState(PS, PS.getLocation(2), PS.getLocation(0));
        else
            return null;
    }

    private State slide3(State state) {
        PuzzleState PS = (PuzzleState) state;
        int t1R = PS.getLocation(3).getRow();
        int t1C = PS.getLocation(3).getColumn();
        int t0R = PS.getLocation(0).getRow();
        int t0C = PS.getLocation(0).getColumn();

        if(((t1R == t0R) && (t1C == t0C+1 || t1C == t0C-1)) || ((t1C == t0C) && (t1R == t0R+1 || t1R == t0R-1)))
            return new PuzzleState(PS, PS.getLocation(3), PS.getLocation(0));
        else
            return null;
    }

    private State slide4(State state) {
        PuzzleState PS = (PuzzleState) state;
        int t1R = PS.getLocation(4).getRow();
        int t1C = PS.getLocation(4).getColumn();
        int t0R = PS.getLocation(0).getRow();
        int t0C = PS.getLocation(0).getColumn();

        if(((t1R == t0R) && (t1C == t0C+1 || t1C == t0C-1)) || ((t1C == t0C) && (t1R == t0R+1 || t1R == t0R-1)))
            return new PuzzleState(PS, PS.getLocation(4), PS.getLocation(0));
        else
            return null;
    }

    private State slide5(State state) {
        PuzzleState PS = (PuzzleState) state;
        int t1R = PS.getLocation(5).getRow();
        int t1C = PS.getLocation(5).getColumn();
        int t0R = PS.getLocation(0).getRow();
        int t0C = PS.getLocation(0).getColumn();

        if(((t1R == t0R) && (t1C == t0C+1 || t1C == t0C-1)) || ((t1C == t0C) && (t1R == t0R+1 || t1R == t0R-1)))
            return new PuzzleState(PS, PS.getLocation(5), PS.getLocation(0));
        else
            return null;
    }

    private State slide6(State state) {
        PuzzleState PS = (PuzzleState) state;
        int t1R = PS.getLocation(6).getRow();
        int t1C = PS.getLocation(6).getColumn();
        int t0R = PS.getLocation(0).getRow();
        int t0C = PS.getLocation(0).getColumn();

        if(((t1R == t0R) && (t1C == t0C+1 || t1C == t0C-1)) || ((t1C == t0C) && (t1R == t0R+1 || t1R == t0R-1)))
            return new PuzzleState(PS, PS.getLocation(6), PS.getLocation(0));
        else
            return null;
    }

    private State slide7(State state) {
        PuzzleState PS = (PuzzleState) state;
        int t1R = PS.getLocation(7).getRow();
        int t1C = PS.getLocation(7).getColumn();
        int t0R = PS.getLocation(0).getRow();
        int t0C = PS.getLocation(0).getColumn();

        if(((t1R == t0R) && (t1C == t0C+1 || t1C == t0C-1)) || ((t1C == t0C) && (t1R == t0R+1 || t1R == t0R-1)))
            return new PuzzleState(PS, PS.getLocation(7), PS.getLocation(0));
        else
            return null;
    }

    private State slide8(State state) {
        PuzzleState PS = (PuzzleState) state;
        int t1R = PS.getLocation(8).getRow();
        int t1C = PS.getLocation(8).getColumn();
        int t0R = PS.getLocation(0).getRow();
        int t0C = PS.getLocation(0).getColumn();

        if(((t1R == t0R) && (t1C == t0C+1 || t1C == t0C-1)) || ((t1C == t0C) && (t1R == t0R+1 || t1R == t0R-1)))
            return new PuzzleState(PS, PS.getLocation(8), PS.getLocation(0));
        else
            return null;
    }

}
