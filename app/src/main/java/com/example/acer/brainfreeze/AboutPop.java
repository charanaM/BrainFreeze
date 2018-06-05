package com.example.acer.brainfreeze;

import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * popup for the about layout.
 */

public class AboutPop extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the xml for about pop-up
        setContentView(R.layout.about_popup);

        //new display matrix layout to scale down
        DisplayMetrics dmpop = new DisplayMetrics();
        //window manager to set metrics
        getWindowManager().getDefaultDisplay().getMetrics(dmpop);

        //popup width in pixels
        int popwidth = dmpop.widthPixels;
        //popup height in pixels
        int popheight = dmpop.heightPixels;

        //set popup layout scale
        getWindow().setLayout((int)(popwidth*.8), (int)(popheight*.6));
    }


}

