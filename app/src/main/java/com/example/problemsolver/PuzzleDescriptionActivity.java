package com.example.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PuzzleDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_description);
    }

    public void openPuzzleProblem(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, PuzzleProblemActivity.class);
        startActivity(intent);
    }
}
