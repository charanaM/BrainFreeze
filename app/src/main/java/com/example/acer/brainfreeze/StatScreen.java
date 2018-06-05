package com.example.acer.brainfreeze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ACER on 3/10/2018.
 * Statistics are displayed after every game.
 * Results of the questions answered will be displayed in here.
 */

public class StatScreen extends Activity {

    //arraylist to score
    ArrayList<Integer> score = new ArrayList<>();

    //integer for question number
    int questionNo;
    //scorelabel textview
    TextView score_lbl;
    //menu button
    Button menu;

    int total;
    int cGuesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //new intent to pass remaining time
        Intent gamesc = getIntent();
        getIntent().getIntExtra("time", 0);

        //get the times array
        score = gamesc.getIntegerArrayListExtra("time");


        score_lbl = (TextView)findViewById(R.id.scoreresult);
        menu = (Button) findViewById(R.id.menu_btn);

        score_lbl.setText("");

        calculateScore();


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(StatScreen.this, MainActivity.class));
            }
        });
    }

    //calculate method
    public void calculateScore(){


        for (int score_time: score){
            //increment question number
            questionNo++;

            //if user give no answer
            if(score_time == 99){
                //append as 0 score
                score_lbl.append("Question No: " + questionNo + " score : 0");
                score_lbl.append(" \n");
            }else{
                //if enters correct answer

                //calculate score
                int cal =(100/(10-score_time));
                //add scores to total
                total += cal;
                //increment current scores
                cGuesses++;
                score_lbl.append("Question No: " + questionNo + " score : " + cal);
                score_lbl.append(" \n");




            }

            if (questionNo == 10){
                //if question number are 10
                score_lbl.append(" \n");
                score_lbl.append(" \n");
                score_lbl.append("Correct guesses : " + cGuesses);
                score_lbl.append(" \n");
                score_lbl.append("Total : " + total);

            }
        }


    }
}
