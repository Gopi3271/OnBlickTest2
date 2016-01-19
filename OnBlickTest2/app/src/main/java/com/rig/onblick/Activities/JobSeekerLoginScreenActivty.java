package com.rig.onblick.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rig.onblick.LinkedinLoginActivity;
import com.rig.onblick.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 1/14/2016.
 */
public class JobSeekerLoginScreenActivty extends Activity implements View.OnClickListener {


    EditText etUserId,etPassword;
    ImageView tVSignin;
    ImageButton imageButton;
    TextView tVRegister;
    TextView tVForgotPassword;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.new_login);
        context=getApplicationContext();
        etUserId = (EditText) findViewById(R.id.etUserId);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tVSignin = (ImageView)findViewById(R.id.jobSeekerLogin);
        tVRegister = (TextView) findViewById(R.id.register);
          imageButton = (ImageButton) findViewById(R.id.imageButton);
       // linkedin=(TextView)findViewById(R.id.tvLink);
         tVForgotPassword=(TextView)findViewById(R.id.forgotPassword);
       // imageButton.setOnClickListener(this);
         tVSignin.setOnClickListener(JobSeekerLoginScreenActivty.this);
         tVRegister.setOnClickListener(JobSeekerLoginScreenActivty.this);
         tVForgotPassword.setOnClickListener(JobSeekerLoginScreenActivty.this);
    }



    public void onLinkedinLogin(View v)
    {
        Intent it = new Intent(JobSeekerLoginScreenActivty.this, LinkedinLoginActivity.class);
        startActivity(it);
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.jobSeekerLogin:

                final String email = etUserId.getText().toString();
                final String password = etPassword.getText().toString();

             if (!isValidEmail(email)) {
                    etUserId.setError("Invalid Email");
                    //Toast.makeText(JobSeekerLoginScreenActivty.this, "Invalid username", Toast.LENGTH_SHORT).show();

                } else {
                    if (!(pass)) {
                        etPassword.setError("Invalid Password");
                       // Toast.makeText(JobSeekerLoginScreenActivty.this, "Invalid password", Toast.LENGTH_SHORT).show();

                    } else {
                       // startActivity(new Intent(getApplicationContext(),JobSeekerLoginScreenActivty.class));


                    }
                }


                break;
            case R.id.register:

                Toast.makeText(JobSeekerLoginScreenActivty.this, "In Process", Toast.LENGTH_SHORT).show();
                Intent it=new Intent(JobSeekerLoginScreenActivty.this,JobseekerRegisterActivity.class);
                startActivity(it);
                break;
            //case R.id.imageButton:

               // Intent it1=new Intent(JobSeekerLoginScreenActivty.this,JobseekerInfoActivity.class);
               // startActivity(it1);
               // break;
            case R.id.forgotPassword:
                Intent it2=new Intent(JobSeekerLoginScreenActivty.this,PasswordReset.class);
                startActivity(it2);

        }
    }


    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    boolean pass;
    // validating password with retype password
    private boolean isValidPassword(String password) {


        if (password == null && password.length() < 6) {


           pass=false;
        }

        return pass;
    }
}
