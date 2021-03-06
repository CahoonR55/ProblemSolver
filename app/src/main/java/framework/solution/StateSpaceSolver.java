package framework.solution;

import framework.graph.Vertex;
import framework.problem.Problem;
import framework.problem.State;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Ryan Cahoon
 * @Section 1
 */
public class StateSpaceSolver extends Solver {

    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue (DEQUE)
     * and set the statistics header.
     * @param problem the problem being solved
     * @param bfs a boolean flag indicating whether BFS is to be performed
     */
    public StateSpaceSolver(Problem problem, boolean bfs) {
        super(problem);
        /* you must provide */
        this.bfs = bfs;
        super.setQueue(new LinkedList<>());
        if(bfs){
            super.getStatistics().setHeader("Breadth-First State Space Search\n");
        }
        else {
            super.getStatistics().setHeader("Depth-First State Space Search\n");
        }
    }

    /**
     * Adds a vertex to the DEQUE.
     * If BFS is being performed, the vertex should be added to the
     * end of the DEQUE, so the DEQUE acts like an ordinary queue.
     * If DFS is being performed, the vertex should be added to the
     * front of the DEQUE, so the DEQUE acts like a stack.
     * @param v
     */
    @Override
    public void add(Vertex v) {
        /* you must provide */
        if(bfs == true)
            this.getQueue().add(v);
        else {
            List list = (List)this.getQueue();
            list.add(0,v);
            this.setQueue(new LinkedList(list));
        }
    }

    /**
     * This method implements the expand operation required by the
     * state space search algorithm:

     Expand(u)
     children = {}
     for each name âˆˆ moveNames do
     child = mover.doMove(name, u)
     if child â‰  null and not OccursOnPath(child, u)
     then d[child] = d[u] + 1
     pred[child] = u
     add child to children
     return children

     * @param u the vertex being expanded
     * @return
     */
    @Override
    public List<Vertex> expand(Vertex u) {
        /* you must provide */
        List<Vertex> children = new ArrayList();
        for(String m : super.getProblem().getMover().getMoveNames()){
            Vertex child = new Vertex(super.getProblem().getMover().doMove(m, (State)u.getData()));
            if(((State)child.getData() != null) && (!occursOnPath(child, u))){
                child.setPredecessor(u);
                child.setDistance(u.getDistance()+1);
                children.add(child);
            }
        }
        return children;
    }

    /**
     * Checks whether a given vertex appears on the predecessor path
     * of a given ancestor.
     * @param v the vertex to check
     * @param ancestor the ancestor vertex of v
     * @return true if v occurs on the predecessor path of ancestor,
     * false otherwise
     */
    public static boolean occursOnPath(Vertex v, Vertex ancestor) {
        /* you must provide */
        boolean onPath = false;
        if(ancestor.equals(v))
            onPath = true;
        else if(ancestor.getPredecessor() != null)
            onPath = occursOnPath(v, ancestor.getPredecessor());
        return onPath;
    }
    /* private instance fields here */
    private final boolean bfs;
}