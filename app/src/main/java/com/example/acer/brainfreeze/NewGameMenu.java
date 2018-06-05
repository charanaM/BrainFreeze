package com.example.acer.brainfreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ACER on 3/4/2018.
 * User can select which level he wants to play from this layout.
 */

public class NewGameMenu extends MainActivity{

    static String level = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newgame);

        Button btnnovice = (Button) findViewById(R.id.novicebtn);
        Button btneasy = (Button) findViewById(R.id.easybtn);
        Button btnmed = (Button) findViewById(R.id.medbtn);
        Button btnguru = (Button) findViewById(R.id.gurubtn);


        btnnovice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = "novice";
                startActivity(new Intent(NewGameMenu.this, GameScreen.class));
                finish();

            }
        });

        btneasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = "easy";
                startActivity(new Intent(NewGameMenu.this, GameScreen.class));
                finish();
            }
        });

        btnmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = "medium";
                startActivity(new Intent(NewGameMenu.this, GameScreen.class));
                finish();
            }
        });

        btnguru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = "guru";
                startActivity(new Intent(NewGameMenu.this, GameScreen.class));
                finish();
            }
        });
    }
}
