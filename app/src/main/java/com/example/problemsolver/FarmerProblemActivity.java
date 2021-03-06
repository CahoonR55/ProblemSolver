package com.example.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import domains.farmer.FarmerMover;
import domains.farmer.FarmerProblem;
import domains.farmer.FarmerState;
import framework.solution.AStarSolver;
import framework.solution.SolvingAssistant;

public class FarmerProblemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_problem);

        FS = new FarmerState("West","West","West","West");
        FP = new FarmerProblem();
        aStar = new AStarSolver(FP);
        status = findViewById(R.id.farmerStatus);
        statistics = findViewById(R.id.farmerStatistics);
        solver = new SolvingAssistant(FP);

        //representation of farmer problem
        FState =(TextView) findViewById(R.id.FState);

        FState.setText(FP.getInitialState().toString());



        //create buttons
        moveFarmer = (Button) findViewById(R.id.moveFarmer);
        moveWolf = (Button) findViewById(R.id.moveWolf);
        moveGoat = (Button) findViewById(R.id.moveGoat);
        moveCabbage = (Button) findViewById(R.id.moveCabbage);

        FS = (FarmerState)FP.getInitialState();
        FState.setText(FS.toString());

    }
    //button actions
    public void farmerButton(View view) {
        handleButton("Farmer Goes Alone");
    }

    public void wolfButton(View view) {
        handleButton("Farmer Takes Wolf");
    }

    public void goatButton(View view) {
        handleButton("Farmer Takes Goat");
    }

    public void cabbageButton(View view) {
        handleButton("Farmer Takes Cabbage");
    }

    //event handler for buttons
    public void handleButton(String move) {
        status.setText("");

        FarmerState FS = (FarmerState)FP.getCurrentState();
        solver.tryMove(move);
        if(solver.isMoveLegal()) {
            FS = (FarmerState) FP.getMover().doMove(move, FS);
            FState.setText(FS.toString());
        }
        else
            status.setText("That move is illegal; Try again.");
        if(solver.isProblemSolved())
            status.setText("Congratulations, you solved the problem! Click reset to try again");
    }

    public void solveButton(View view) {
        aStar.solve();
        statistics.setText(aStar.getStatistics().toString());

        aStar.getSolution().next();

        isSolved = true;
    }

    public void nextButton(View view) {
        if(aStar.getSolution().hasNext() && isSolved == true) {
            FS = (FarmerState) aStar.getSolution().next().getData();
            FState.setText(FS.toString());
        }
    }

    public void resetButton(View view) {
        solver.reset();
        isSolved = false;
        statistics.setText("Press 'Solve' to solve the problem and see statistics.");
        status.setText("");
        FState.setText(FP.getInitialState().toString());
    }

    public void openMain(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    Button moveFarmer;
    Button moveWolf;
    Button moveGoat;
    Button moveCabbage;
    FarmerState FS;
    FarmerProblem FP;
    private SolvingAssistant solver;
    private AStarSolver aStar;
    TextView status;
    TextView statistics;
    TextView FState;
    boolean isSolved = false;

}

