package org.forestpark.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView questionText;
    TextView qTitleText;
    Button trueBtn;
    Button falseBtn;
    Button startBtn;
    Button finishBtn;
    ImageView questionImage;
    boolean startClk = false;
    int intI = 0;
    static int score = 10;
    String[] questionList = {"You can take more than 3 steps without dribbling in basketball", "You can stay in the paint for more than 3 seconds in basketball", "A point outside the arc is a 3 point shot in basketball", "You get ejected out of the game after 6 fouls in basketball", "Complaining to the referee is a technical foul in basketball", "You can dribble after picking up the ball in basketball", "You get 2 points for dunking in basketball", "You can hold the ball after jumping in basketball", "There are 5 players on the court per team in basketball", "You can shoot at the opposite goal in basketball"};
    String[] answerList = {"false", "false", "true", "true", "true", "false","true", "false", "true", "false"};
    int[] pictureList = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionText = findViewById(R.id.QuestionText);
        qTitleText = findViewById(R.id.QTitleText);
        trueBtn = findViewById(R.id.TrueBtn);
        falseBtn = findViewById(R.id.FalseBtn);
        startBtn = findViewById(R.id.StartBtn);
        finishBtn = findViewById(R.id.FinishBtn);
        questionImage = findViewById(R.id.QuizImage);

        startBtn.setOnClickListener(v -> {
            if (!startClk) {
                intI = 0;
                questionText.setText(questionList[intI]);
                questionImage.setBackgroundResource(pictureList[intI]);
                questionText.setVisibility(View.VISIBLE);
                trueBtn.setVisibility(View.VISIBLE);
                falseBtn.setVisibility(View.VISIBLE);
                questionImage.setVisibility(View.VISIBLE);
                finishBtn.setVisibility(View.INVISIBLE);
                qTitleText.setText("Press Stop to Reset");
                startBtn.setText("Stop");
                startClk = true;
            } else {
                intI = 0;
                questionText.setVisibility(View.INVISIBLE);
                trueBtn.setVisibility(View.INVISIBLE);
                falseBtn.setVisibility(View.INVISIBLE);
                qTitleText.setText("Press Start Button");
                finishBtn.setVisibility(View.INVISIBLE);
                questionImage.setVisibility(View.INVISIBLE);
                startBtn.setText("Start");
                startClk = false;
            }
        });
        falseBtn.setOnClickListener(v -> {
            if (answerList[intI].equals("false")) {
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                if(questionList[intI].equals("You can shoot at the opposite goal in basketball")) {
                    trueBtn.setVisibility(View.INVISIBLE);
                    falseBtn.setVisibility(View.INVISIBLE);
                    finishBtn.setVisibility(View.VISIBLE);
                    questionImage.setVisibility(View.INVISIBLE);
                    questionText.setText("You're all done! Go check your score by hitting the finish button");
                } else {
                    intI++;
                    questionText.setText(questionList[intI]);
                    questionImage.setBackgroundResource(pictureList[intI]);
                }
            } if (answerList[intI].equals("true")) {
                Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_LONG).show();
                intI++;
                questionText.setText(questionList[intI]);
                questionImage.setBackgroundResource(pictureList[intI]);
                score -= 1;
                }
            });

        trueBtn.setOnClickListener(v -> {
            if (answerList[intI].equals("true")) {
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                if(questionList[intI].equals("You can shoot at the opposite goal in basketball")) {
                    trueBtn.setVisibility(View.INVISIBLE);
                    falseBtn.setVisibility(View.INVISIBLE);
                    finishBtn.setVisibility(View.VISIBLE);
                    questionImage.setVisibility(View.INVISIBLE);
                    questionText.setText("You're all done! Go check your score by hitting the finish button");
                } else {
                    intI++;
                    questionText.setText(questionList[intI]);
                    questionImage.setBackgroundResource(pictureList[intI]);
                }
            } if (answerList[intI].equals("false")) {
                Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_LONG).show();
                intI++;
                questionText.setText(questionList[intI]);
                questionImage.setBackgroundResource(pictureList[intI]);
                score -= 1;
                }
            });

        finishBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ScoreActivity.class)));
    }
}