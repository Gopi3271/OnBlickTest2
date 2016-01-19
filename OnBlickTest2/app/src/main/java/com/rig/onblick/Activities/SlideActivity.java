package com.rig.onblick.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.rig.onblick.Adapters.FullScreenImageAdapter;
import com.rig.onblick.R;

public class SlideActivity extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences preferences;
    ImageView slideImage;
    TextView tvSkip;
    FullScreenImageAdapter adapter;
    private ViewPager viewPager;
    int imgList[] = {R.mipmap.new_intro1, R.mipmap.new_intro2, R.mipmap.new_intro3,R.mipmap.new_intro4};
    RadioButton rbOne, rbTwo, rbThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.images_slide);
        tvSkip = (TextView) findViewById(R.id.tvSkip);


        preferences = getSharedPreferences("prefName", MODE_APPEND);
        viewPager = (ViewPager) findViewById(R.id.pager);
        int imagess = preferences.getInt("images", 0);

        tvSkip.setOnClickListener(SlideActivity.this);
       // slideImage = (ImageView) findViewById(R.id.spLang);
        adapter = new FullScreenImageAdapter(SlideActivity.this, imgList);
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    @Override
    public void onClick(View v) {

        Intent i = new Intent(getApplicationContext(),RecurtierActivity.class);
        startActivity(i);
    }


    }

