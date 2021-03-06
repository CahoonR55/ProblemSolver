package framework.solution;
import framework.graph.Vertex;
import java.util.Stack;
/**
 * A solution for the FWGC problem
 * @author Ryan Cahoon
 * @section 1
 */

public class Solution {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        this.curr = end;
        this.vStack = new Stack();

        //initialize vStack
        do {
            vStack.push(this.curr);
            this.curr = this.curr.getPredecessor();
            length++;

        } while((Vertex)vStack.peek() != this.start);
    }

    /**
     * Gets the length of the solution, that is, the number of moves
     * to get to the end state from the start.
     * @return the solution length
     */
    public int getLength() {

        return length-1;
    }

    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    public boolean hasNext() {
        /* you must provide */
        boolean hasNext = false;
        try{
            if(vStack.empty() == false)
                hasNext = true;
        } catch(NullPointerException Nex){}
        return hasNext;

    }

    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    public Vertex next() {
        if(vStack.isEmpty() == false) {
            curr = (Vertex)vStack.pop();

        }
        else
            throw new RuntimeException("no more vertices.");
        return curr;
    }

    /* private instance fields and methods here */
    private Stack vStack;
    private int length = 0;
    private Vertex start;
    private Vertex end;
    private Vertex curr;

}