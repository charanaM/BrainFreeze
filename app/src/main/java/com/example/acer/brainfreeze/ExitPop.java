package com.example.acer.brainfreeze;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * exit popup asking whether to save or not.
 */

public class ExitPop extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set xml for exit popup
        setContentView(R.layout.exit_popup);

        //declare button to save and exit
        Button yes = (Button) findViewById(R.id.yesbtn);
        //declare button to exit only
        Button no = (Button) findViewById(R.id.nobtn);

        //new display matrix layout to scale down
        DisplayMetrics dmpop = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dmpop);

        //popup width and height in pixels
        int popwidth = dmpop.widthPixels;
        int popheight = dmpop.heightPixels;

        //set popup layout scale
        getWindow().setLayout((int)(popwidth*.8), (int)(popheight*.6));

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
