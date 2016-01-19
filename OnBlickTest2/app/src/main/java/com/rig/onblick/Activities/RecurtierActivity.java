package com.rig.onblick.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.rig.onblick.R;

public class RecurtierActivity extends Activity implements View.OnClickListener {
    ImageView ivJobSeeker,ivRecuiter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_intro);

        ivJobSeeker = (ImageView) findViewById(R.id.ivJobSeeker);
        ivRecuiter = (ImageView) findViewById(R.id.ivRecurtier);

        ivJobSeeker.setOnClickListener(this);
        ivRecuiter.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.ivJobSeeker:

                Intent i = new Intent(RecurtierActivity.this,JobSeekerLoginScreenActivty.class);
                startActivity(i);

                break;
            case R.id.ivRecurtier:


                Intent i1 = new Intent(getApplicationContext(),RecuriterLoginScreenActivty.class);
                startActivity(i1);

                break;

        }
    }
}
