package framework.solution;

import domains.puzzle.PuzzleState;
import framework.graph.Vertex;
import framework.problem.Problem;
import framework.problem.State;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This class represents an A* solver by extending the StateSpaceSolver
 * class.
 * @author Ryan Cahoon
 * @Section 1
 */
public class AStarSolver extends StateSpaceSolver {

    /**
     * Creates an A* solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem
     */
    public AStarSolver(Problem problem) {
        super(problem, false);
        this.PQ = new PriorityQueue(this.getComparator());
        super.setQueue(PQ);
        super.getStatistics().setHeader("A* Search\n");
    }

    /**
     * Adds a vertex to the PQ.
     * @param v the vertex to be added
     */
    @Override
    public void add(Vertex v) {
        PQ.add(v);
    }

    /**
     * Creates a comparator object that compares vertices for ordering
     * in a PQ during A* search.
     * This should be used when creating the PQ.
     * @return the comparator object
     */
    public final Comparator<Vertex> getComparator() {
        return (vertice1, vertice2) -> {
            PuzzleState goal =
                    new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}});
            State state1 = (State)vertice1.getData();
            State state2 = (State)vertice2.getData();
            int heuristic1 = state1.getHeuristic(goal);
            int heuristic2 = state2.getHeuristic(goal);
            heuristic1 += vertice1.getDistance();
            heuristic2 += vertice2.getDistance();
            return heuristic1 - heuristic2;
        };
    }

    private PriorityQueue PQ;
}