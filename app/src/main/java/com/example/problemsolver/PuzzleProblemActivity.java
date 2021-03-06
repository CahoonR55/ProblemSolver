package com.example.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;
import framework.solution.AStarSolver;
import framework.solution.SolvingAssistant;

public class PuzzleProblemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_problem);

        startArr = new int[][]{{5,2,7}, {8,0,4}, {3,6,1}};
        startState = new PuzzleState(startArr);

        status = findViewById(R.id.puzzleStatus);
        statistics = findViewById(R.id.puzzleStats);

        problem = new PuzzleProblem(startArr);
        solver = new SolvingAssistant(problem);

        aStar = new AStarSolver(problem);
        tiles = new ArrayList<Button>();

        //initialize buttons
        tile1 = findViewById(R.id.tile1);
        tile2 = findViewById(R.id.tile2);
        tile3 = findViewById(R.id.tile3);
        tile4 = findViewById(R.id.tile4);
        tile5 = findViewById(R.id.tile5);
        tile6 = findViewById(R.id.tile6);
        tile7 = findViewById(R.id.tile7);
        tile8 = findViewById(R.id.tile8);

        tiles.add(tile1);
        tiles.add(tile2);
        tiles.add(tile3);
        tiles.add(tile4);
        tiles.add(tile5);
        tiles.add(tile6);
        tiles.add(tile7);
        tiles.add(tile8);

        resetGrid();
    }

    public void tile1Button(View view) {
        handleButton("SLIDE TILE 1", 1);
    }

    public void tile2Button(View view) {
        handleButton("SLIDE TILE 2", 2);
    }

    public void tile3Button(View view) {
        handleButton("SLIDE TILE 3", 3);
    }

    public void tile4Button(View view) {
        handleButton("SLIDE TILE 4", 4);
    }

    public void tile5Button(View view) {
        handleButton("SLIDE TILE 5", 5);
    }

    public void tile6Button(View view) {
        handleButton("SLIDE TILE 6", 6);
    }

    public void tile7Button(View view) {
        handleButton("SLIDE TILE 7", 7);
    }

    public void tile8Button(View view) {
        handleButton("SLIDE TILE 8", 8);
    }

    //Button handler
    public void handleButton(String move, int tile) {
        status.setText("");

        state = (PuzzleState)problem.getCurrentState();
        solver.tryMove(move);
        Button button = (Button)tiles.get(tile-1);

        if(solver.isMoveLegal())
            button.setLayoutParams(new GridLayout.LayoutParams(
                    buttonGrid.spec(state.getLocation(0).getRow()),
                    buttonGrid.spec(state.getLocation(0).getColumn())));
        else
            status.setText("That move is illegal; Try again.");
        if(solver.isProblemSolved())
            status.setText("Congratulations, you solved the problem! Click reset to try again");
    }

    public void resetGrid() {
        PuzzleState state = startState;
        for(int i=0; i<8; ++i) {
            Button b = (Button) tiles.get(i);
            b.setLayoutParams(new GridLayout.LayoutParams(
                    buttonGrid.spec(state.getLocation(i + 1).getRow()),
                    buttonGrid.spec(state.getLocation(i + 1).getColumn())));
        }
    }

    public void solveButton(View view) {
        aStar.solve();
        statistics.setText(aStar.getStatistics().toString());

        aStar.getSolution().next();

        solved = true;
    }

    public void nextButton(View view) {
        if(aStar.getSolution().hasNext() && solved == true) {
            state = (PuzzleState) aStar.getSolution().next().getData();
            for(int i=0; i<8; i++) {
                Button b = (Button) tiles.get(i);
                b.setLayoutParams(new GridLayout.LayoutParams(
                        buttonGrid.spec(state.getLocation(i + 1).getRow()),
                        buttonGrid.spec(state.getLocation(i + 1).getColumn())));
            }
        }
    }

    public void resetButton(View view) {
        solver.reset();
        solved = false;
        statistics.setText("Press 'Solve' to solve the problem and see statistics.");
        status.setText("");
        resetGrid();

    }

    public void openMain(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private SolvingAssistant solver;
    PuzzleState state;
    int[][] startArr;
    PuzzleState startState;
    PuzzleProblem problem;
    TextView status;
    TextView statistics;
    private AStarSolver aStar;
    GridLayout buttonGrid;
    Button tile1,tile2,tile3,tile4,tile5,tile6,tile7,tile8;
    private boolean solved = false;
    ArrayList tiles;
}
