package com.example.acer.brainfreeze;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ACER on 3/4/2018.
 * Main game screen of the app. Calculations, timers and all the core functions are used in this class.
 *
 */

public class GameScreen extends NewGameMenu {

    //declare textviews
    TextView numb;
    TextView question;
    TextView answer;
    TextView lvl_lbl;
    TextView timer_label;
    TextView result;
    TextView hint;

    //declare checkbox for hint
    CheckBox hint_Check;

    //declare integers to store values
    int answr;
    int real_answr;
    int termNo;
    int min_terms;
    int max_terms;
    int solution1, solution2, solution3, solution4, solution5;

    int enterpressed = 0;
    int attempts;

    int que_no;

    //array for operators
    final String[] oprtrs = {"+", "-", "/", "*"};
    Random random = new Random();

    //arraylist for randomly generated operators
    ArrayList<Integer> operatorArr = new ArrayList<>();

    //arraylist for randomly generated numbers
    ArrayList<Integer> numberArr = new ArrayList<>();

    //arraylist for both randomly generated numbers and operators both
    ArrayList<String> wholeArr = new ArrayList<>();

    //arraylist for remaining time
    ArrayList<Integer> questionTime = new ArrayList<>();

    private final int math_add = 0;
    private final int math_sub = 1;
    private final int math_dev = 2;
    private final int math_mul = 3;

    //countdown object
    CountDownTimer countdown;

    long timeLeft;

    //countdown start
    final long countdownSt = 11 * 1000;
    //countdown interval
    final long countdownIntv = 1 * 1000;

    boolean continuestat = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamesc);


        int input_value = 0;


        //declaring buttons for dialpad
        Button bt0 = (Button) findViewById(R.id.btn0);
        Button bt1 = (Button) findViewById(R.id.btn1);
        Button bt2 = (Button) findViewById(R.id.btn2);
        Button bt3 = (Button) findViewById(R.id.btn3);
        Button bt4 = (Button) findViewById(R.id.btn4);
        Button bt5 = (Button) findViewById(R.id.btn5);
        Button bt6 = (Button) findViewById(R.id.btn6);
        Button bt7 = (Button) findViewById(R.id.btn7);
        Button bt8 = (Button) findViewById(R.id.btn8);
        Button bt9 = (Button) findViewById(R.id.btn9);

        //declaring button for delete
        Button btc = (Button) findViewById(R.id.btnc);
        //declaring button for ok (#)
        Button btok = (Button) findViewById(R.id.btnok);
        //declaring button for minus
        Button btminus = (Button) findViewById(R.id.btnminus);


        numb = (TextView) findViewById(R.id.input_lbl);
        numb.setText("?");
        question = (TextView) findViewById(R.id.ques_lbl);
        answer = (TextView) findViewById(R.id.ans_lbl);
        lvl_lbl = (TextView) findViewById(R.id.level_lbl);
        timer_label = (TextView)findViewById(R.id.timer_lbl);
        result = (TextView)findViewById(R.id.result_lbl);
        hint = (TextView)findViewById(R.id.hint_lbl);


        hint_Check = (CheckBox)findViewById(R.id.hintCheck);



       // que_no = gameplay.getIntExtra("qNo", 0);

        if(que_no !=0){
            continuestat=true;
        }

        newQuestion();


        //button 0 on click
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"0");
                }
                else {
                    numb.setText(numb.getText() + "0");
                }
            }
        });

        //button 1 on click
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"1");
                }
                else {
                    numb.setText(numb.getText() + "1");
                }
            }
        });

        //button 2 on click
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"2");
                }
                else {
                    numb.setText(numb.getText() + "2");
                }
            }
        });

        //button 3 on click
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"3");
                }
                else {
                    numb.setText(numb.getText() + "3");
                }
            }
        });

        //button 4 on click
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"4");
                }
                else {
                    numb.setText(numb.getText() + "4");
                }
            }
        });

        //button 5 on click
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"5");
                }
                else {
                    numb.setText(numb.getText() + "5");
                }
            }
        });

        //button 6 on click
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"6");
                }
                else {
                    numb.setText(numb.getText() + "6");
                }
            }
        });

        //button 7 on click
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"7");
                }
                else {
                    numb.setText(numb.getText() + "7");
                }
            }
        });

        //button 8 on click
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"8");
                }
                else {
                    numb.setText(numb.getText() + "8");
                }
            }
        });

        //button 9 on click
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously
                if(numb.getText().toString().endsWith("?")){
                    numb.setText("");
                    numb.setText(numb.getText()+"9");
                }
                else {
                    numb.setText(numb.getText() + "9");
                }
            }
        });

        //button cancel on click
        btc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously or is empty
                if((numb.getText().toString().endsWith("?")) || (numb.getText().toString().isEmpty())){

                }
                else {
                    String text = numb.getText().toString();
                    numb.setText(text.substring(0, text.length() - 1));
                }

            }

        });

        //button ok on click
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check whether there are numbers entered previously or is empty
                if((numb.getText().toString().endsWith("?")) || (numb.getText().toString().endsWith("-")) || (numb.getText().toString().isEmpty())){

                }
                else {
                    //counter for number of times ok pressed
                    enterpressed++;

                    //if ok pressed only once
                    if (enterpressed == 1) {


                        answer.setText(numb.getText());
                        answr = Integer.parseInt(answer.getText() + "");

                        //if user enters real answer
                        if (answr == real_answr) {
                            countdown.cancel();
                            questionTime.add((int)timeLeft);
                            result.setTextColor(Color.rgb(0, 255, 0));
                            hint.setText("");
                            result.setText("Correct!!");

                        } else { //if answer is wrong

                            result.setTextColor(Color.rgb(255, 0, 0));
                            result.setText("Wrong!!");

                            //if the hint is on
                            if (hint_Check.isChecked()) {

                                //increment number of tries
                                attempts++;

                                if (attempts < 4) {
                                    enterpressed = 0;
                                    if (answr < real_answr) {
                                        hint.setText("Greater");
                                    } else {
                                        hint.setText("Lesser");
                                    }

                                } else {
                                    countdown.cancel();
                                    questionTime.add(99);
                                    //enterpressed++;
                                    //result.setText("Result");

                                }


                            } else {
                                countdown.cancel();
                                questionTime.add(99);
                                hint.setText("");
                            }


                        }
                        // answer.setText(String.valueOf(real_answr));

//                    if(answr == real_answr){
//                        answer.setText("Correct");
//                    }
                    }
                }
                //if ok pressed twice
                if(enterpressed == 2){
                    //countdown.cancel();

                    newQuestion();
                    enterpressed = 0;
                    attempts = 0;
                    result.setText("");
                    hint.setText("");
                }else {

                }



            }
        });

        //button minus on click
        btminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((numb.getText().toString().endsWith("?")) || (numb.getText().toString().isEmpty())){
                    numb.setText("-");
                }


            }
        });



        Log.i("LEVEL", level);

        //switch for levels
        switch (level){
            case ("novice"):
                //setting min terms and max terms for novice level
                lvl_lbl.setText("NOVICE");
                min_terms = 2;
                max_terms = 2;
                break;

            case ("easy"):
                //setting min terms and max terms for easy level
                lvl_lbl.setText("EASY");
                min_terms = 2;
                max_terms = 3;
                break;

            case ("medium"):
                //setting min terms and max terms for medium level
                lvl_lbl.setText("MEDIUM");
                min_terms = 2;
                max_terms = 4;
                break;

            case ("guru"):
                //setting min terms and max terms for guru level
                lvl_lbl.setText("GURU");
                min_terms = 4;
                max_terms = 6;
                break;

        }

    }


    //=============================================================================================================================

    //countdown timer

    public class NewCountdownT extends CountDownTimer{

        public NewCountdownT(long time_start, long time_interval){
            super(time_start, time_interval);
        }

        @Override
        public void onFinish() {
            //when 10 seconds go
            timer_label.setText("Timeout!");
            questionTime.add(99);
            newQuestion();

        }

        @Override
        public void onTick(long Remaining) {
            //timeout
            timeLeft = (Remaining/1000);
            timer_label.setText("Time Left : " + timeLeft);

        }
    }


    //===================================================================================================================================

    //method for new question
    public void newQuestion(){


        numb.setText("?");

        //if question number is not
        if (que_no != 10){

            //increment question number
            que_no++;

            //make a toast to display
            Toast.makeText(getBaseContext(), "Question:" + (String.valueOf(que_no)),
                    Toast.LENGTH_SHORT).show();



            countdown = new NewCountdownT(countdownSt, countdownIntv);
            timer_label.setText("Time Left : " + String.valueOf(countdownSt / 1000));
            countdown.start();


            if(continuestat == false){

                switch (level){
                    case ("novice"):
                        lvl_lbl.setText("NOVICE");
                        min_terms = 2;
                        max_terms = 2;
                        break;

                    case ("easy"):
                        lvl_lbl.setText("EASY");
                        min_terms = 2;
                        max_terms = 3;
                        break;

                    case ("medium"):
                        lvl_lbl.setText("MEDIUM");
                        min_terms = 2;
                        max_terms = 4;
                        break;

                    case ("guru"):
                        lvl_lbl.setText("GURU");
                        min_terms = 4;
                        max_terms = 6;
                        break;

                }

                //clear arrays
                numberArr.clear();
                operatorArr.clear();
                wholeArr.clear();


                termNo = random.nextInt((max_terms + 1) - min_terms) + min_terms;

                for (int i = 1; i <= termNo; i++) {
                    int randomInt = random.nextInt(100 - 1) + 1;

                    numberArr.add(randomInt);
                    wholeArr.add(String.valueOf(randomInt));

                    if (i != termNo) {
                        int randomOp = new Random().nextInt(oprtrs.length);

                        //add random operator
                        operatorArr.add(randomOp);

                        //add to whole array
                        wholeArr.add(oprtrs[randomOp]);

                    }

                }


            }else{
                termNo = 2;
                continuestat = false;
            }


            switch ((termNo)){

                case (2):
                    //get random integers and operator
                    calculate(1, numberArr.get(0), numberArr.get(1), operatorArr.get(0));
                    //set solution to real answer variable
                    real_answr = solution1;
                    Log.i("in", "case 2");

                    break;


                case (3):
                    //get random integers and operator
                    calculate(1, numberArr.get(0), numberArr.get(1), operatorArr.get(0));
                    //get random integers and operator for third term
                    calculate(2, solution1, numberArr.get(2), operatorArr.get(1));
                    //set solution to real answer variable
                    real_answr = solution2;
                    break;



                case (4):
                    //get random integers and operator
                    calculate(1, numberArr.get(0), numberArr.get(1), operatorArr.get(0));
                    //get random integers and operator for third term
                    calculate(2, solution1, numberArr.get(2), operatorArr.get(1));
                    //get random integers and operator for fourth term
                    calculate(3, solution2, numberArr.get(3), operatorArr.get(2));
                    //set solution to real answer variable
                    real_answr = solution3;
                    break;



                case (5):
                    //get random integers and operator
                    calculate(1, numberArr.get(0), numberArr.get(1), operatorArr.get(0));
                    //get random integers and operator for next term
                    calculate(2, solution1, numberArr.get(2), operatorArr.get(1));
                    //get random integers and operator for next term
                    calculate(3, solution2, numberArr.get(3), operatorArr.get(2));
                    //get random integers and operator for next term
                    calculate(4, solution3, numberArr.get(4), operatorArr.get(3));
                    //set solution to real answer variable
                    real_answr = solution4;

                    break;


                case (6):

                    //get random integers and operator
                    calculate(1, numberArr.get(0), numberArr.get(1), operatorArr.get(0));
                    //get random integers and operator for next term
                    calculate(2, solution1, numberArr.get(2), operatorArr.get(1));
                    //get random integers and operator for next term
                    calculate(3, solution2, numberArr.get(3), operatorArr.get(2));
                    //get random integers and operator for next term
                    calculate(4, solution3, numberArr.get(4), operatorArr.get(3));
                    //get random integers and operator for next term
                    calculate(5, solution4, numberArr.get(5), operatorArr.get(4));
                    //set solution to real answer variable
                    real_answr = solution5;
                    break;
            }



            String que = "";

            for (String genNumbers : wholeArr) {
                que += genNumbers;
            }

            Log.i("QUESTION", que);

            question.setText(que);


        }else{
            countdown.cancel();
            finish();
            Intent scoreboard = new Intent(getApplicationContext(), StatScreen.class);
            scoreboard.putExtra("time", questionTime );
            startActivity(scoreboard);
        }

        answer.setText(String.valueOf(real_answr));
        Log.i("answer", String.valueOf(real_answr));
        wholeArr.clear();

    }

    //========================================================================================================================


    public void calculate(int pair, int value1, int value2, int oper) {
        int result = 0;
        switch (oper) {
            //set case for add
            case math_add:
                result = (value1 + value2);
                break;
            //set case for sub
            case math_sub:
                result = (value1 - value2);
                break;
            //set case for devetion
            case math_dev:
                result = (value1 / value2);
                break;
            //set case for multiply
            case math_mul:
                result = (value1 * value2);
                break;
            default:
                break;

        }

        switch (pair) {
            case 1:
                solution1 = result;
                break;

            case 2:
                solution2 = result;
                break;

            case 3:
                solution3 = result;
                break;

            case 4:
                solution4 = result;
                break;

            case 5:
                solution5 = result;
                break;


        }


    }

}
