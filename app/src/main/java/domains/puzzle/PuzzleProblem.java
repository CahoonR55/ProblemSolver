package domains.puzzle;

import framework.problem.Benchmark;
import framework.problem.Problem;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Ryan Cahoon
 */
public class PuzzleProblem extends Problem{

    int[][] initArr = new int[][]{{2,8,3}, {1,6,4}, {7,0,5}};
    int[][] finalArr = new int[][]{{1,2,3}, {8,0,4}, {7,6,5}};

    public PuzzleProblem() {
        super();
        super.setName("8-Puzzle");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        super.setInitialState(new PuzzleState(initArr));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new PuzzleState(finalArr));

        //create benchmarks
        b1 = new Benchmark();
        b1.setName("Bench 1: 5 moves");
        b1.setStart(new PuzzleState(new int[][]{ new int[]{2, 8, 3}, new int[]{1, 6, 4}, new int[]{7, 0, 5}}));
        b1.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b2 = new Benchmark();
        b2.setName("Bench 2: 10 moves");
        b2.setStart(new PuzzleState(new int[][]{ new int[]{3, 6, 4}, new int[]{1, 0, 2}, new int[]{8, 7, 5}}));
        b2.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b3 = new Benchmark();
        b3.setName("Bench 3: 13 moves");
        b3.setStart(new PuzzleState(new int[][]{ new int[]{3, 0, 4}, new int[]{1, 6, 5}, new int[]{8, 2, 7}}));
        b3.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b4 = new Benchmark();
        b4.setName("Bench 4: 18 moves");
        b4.setStart(new PuzzleState(new int[][]{ new int[]{2, 1, 3}, new int[]{8, 0, 4}, new int[]{6, 7, 5}}));
        b4.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b5 = new Benchmark();
        b5.setName("Bench 5: 20 moves");
        b5.setStart(new PuzzleState(new int[][]{ new int[]{4, 2, 0}, new int[]{8, 3, 6}, new int[]{7, 5, 1}}));
        b5.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b6 = new Benchmark();
        b6.setName("Bench 6: 24 moves");
        b6.setStart(new PuzzleState(new int[][]{ new int[]{1, 6, 3}, new int[]{4, 0, 8}, new int[]{7, 2, 5}}));
        b6.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b7 = new Benchmark();
        b7.setName("Bench 7: 30 moves");
        b7.setStart(new PuzzleState(new int[][]{ new int[]{5, 2, 7}, new int[]{8, 0, 4}, new int[]{3, 6, 1}}));
        b7.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b8 = new Benchmark();
        b8.setName("Bench 8: 30 moves");
        b8.setStart(new PuzzleState(new int[][]{ new int[]{5, 6, 7}, new int[]{4, 0, 8}, new int[]{3, 2, 1}}));
        b8.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        //add benchmarks to problem
        benchmarks = new LinkedList<>();
        benchmarks.add(b1);
        benchmarks.add(b2);
        benchmarks.add(b3);
        benchmarks.add(b4);
        benchmarks.add(b5);
        benchmarks.add(b6);
        benchmarks.add(b7);
        benchmarks.add(b8);
        super.setBenchmarks(benchmarks);
    }

    public PuzzleProblem(int[][] initialArr) {
        super();
        super.setName("8-Puzzle");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        super.setInitialState(new PuzzleState(initialArr));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new PuzzleState(finalArr));

        //create benchmarks
        b1 = new Benchmark();
        b1.setName("Bench 1: 5 moves");
        b1.setStart(new PuzzleState(new int[][]{ new int[]{2, 8, 3}, new int[]{1, 6, 4}, new int[]{7, 0, 5}}));
        b1.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b2 = new Benchmark();
        b2.setName("Bench 2: 10 moves");
        b2.setStart(new PuzzleState(new int[][]{ new int[]{3, 6, 4}, new int[]{1, 0, 2}, new int[]{8, 7, 5}}));
        b2.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b3 = new Benchmark();
        b3.setName("Bench 3: 13 moves");
        b3.setStart(new PuzzleState(new int[][]{ new int[]{3, 0, 4}, new int[]{1, 6, 5}, new int[]{8, 2, 7}}));
        b3.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b4 = new Benchmark();
        b4.setName("Bench 4: 18 moves");
        b4.setStart(new PuzzleState(new int[][]{ new int[]{2, 1, 3}, new int[]{8, 0, 4}, new int[]{6, 7, 5}}));
        b4.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b5 = new Benchmark();
        b5.setName("Bench 5: 20 moves");
        b5.setStart(new PuzzleState(new int[][]{ new int[]{4, 2, 0}, new int[]{8, 3, 6}, new int[]{7, 5, 1}}));
        b5.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b6 = new Benchmark();
        b6.setName("Bench 6: 24 moves");
        b6.setStart(new PuzzleState(new int[][]{ new int[]{1, 6, 3}, new int[]{4, 0, 8}, new int[]{7, 2, 5}}));
        b6.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b7 = new Benchmark();
        b7.setName("Bench 7: 30 moves");
        b7.setStart(new PuzzleState(new int[][]{ new int[]{5, 2, 7}, new int[]{8, 0, 4}, new int[]{3, 6, 1}}));
        b7.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        b8 = new Benchmark();
        b8.setName("Bench 8: 30 moves");
        b8.setStart(new PuzzleState(new int[][]{ new int[]{5, 6, 7}, new int[]{4, 0, 8}, new int[]{3, 2, 1}}));
        b8.setGoal(new PuzzleState(new int[][]{ new int[]{1, 2, 3}, new int[]{8, 0, 4}, new int[]{7, 6, 5}}));

        //add benchmarks to problem
        benchmarks = new LinkedList<>();
        benchmarks.add(b1);
        benchmarks.add(b2);
        benchmarks.add(b3);
        benchmarks.add(b4);
        benchmarks.add(b5);
        benchmarks.add(b6);
        benchmarks.add(b7);
        benchmarks.add(b8);
        super.setBenchmarks(benchmarks);
    }

    private static final String INTRO =
            "You are given a board in which numbered tiles can slide" +
                    " around. There is one blank space that holds" +
                    " no tile.  A legal\n" + "move consists of sliding a" +
                    " tile into the blank space if the tile is adjacent" +
                    " to it. The goal is to move tiles around until the\n" +
                    "board looks like the final state below.\n";
    private List<Benchmark> benchmarks;
    private Benchmark b1;
    private Benchmark b2;
    private Benchmark b3;
    private Benchmark b4;
    private Benchmark b5;
    private Benchmark b6;
    private Benchmark b7;
    private Benchmark b8;
}
