package org.forestpark.quizapp;

import static org.forestpark.quizapp.MainActivity.score;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        result = (TextView) findViewById(R.id.Result);
        result.setText("10/10");

    }
}