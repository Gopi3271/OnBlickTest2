package com.rig.onblick.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.rig.onblick.R;

/**
 * Created by Admin on 1/7/2016.
 */
public class IntraductoryActivty extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intraductory_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(IntraductoryActivty.this,
                          JobSeekerLoginScreenActivty.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
