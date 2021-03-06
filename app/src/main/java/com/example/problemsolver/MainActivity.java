package com.example.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFarmerDescription(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, FarmerDescriptionActivity.class);
        startActivity(intent);
    }

    public void openPuzzleDescription(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, PuzzleDescriptionActivity.class );
        startActivity(intent);
    }
}
