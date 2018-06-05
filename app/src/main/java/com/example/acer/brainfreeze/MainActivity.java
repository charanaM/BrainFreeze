package com.example.acer.brainfreeze;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Main menu of the app.
 * User can select whether to go for a new gae, continue the last game, view game help or to exit.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //"about" button declaration
        Button about = (Button) findViewById(R.id.aboutbtn);
        Button exit = (Button) findViewById(R.id.exitbtn);
        Button newGame = (Button) findViewById(R.id.newgbtn);

        //set on click listener for the about button
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutPop.class));

            }
        });

        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExitPop.class));
            }
        });

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewGameMenu.class));
                finish();

            }
        });
    }
}
