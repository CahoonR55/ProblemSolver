package com.example.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FarmerDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_description);
    }

    public void openFarmerProblem(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, FarmerProblemActivity.class);
        startActivity(intent);
    }
}
