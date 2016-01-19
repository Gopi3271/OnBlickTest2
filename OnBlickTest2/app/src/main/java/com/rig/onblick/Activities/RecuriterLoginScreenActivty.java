package com.rig.onblick.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rig.onblick.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 1/9/2016.
 */
public class RecuriterLoginScreenActivty extends Activity implements View.OnClickListener {
    EditText etUserId,etPassword;
    TextView tvSignIn,tvForgotPassword,tvReterivePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.recurtier_login);

        initiliazeControls();
    }

    private void initiliazeControls() {

        etUserId = (EditText) findViewById(R.id.etUserId);
        etPassword = (EditText) findViewById(R.id.etPassword);

        tvSignIn = (TextView) findViewById(R.id.tvSignIn);
        tvForgotPassword = (TextView) findViewById(R.id.tvForgotPassword);
        tvReterivePassword = (TextView) findViewById(R.id.tvReterivePassword);

        tvSignIn.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        tvReterivePassword.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.tvSignIn:



                final String email = etUserId.getText().toString();
                final String pass = etPassword.getText().toString();

                if (!isValidEmail(email)) {
                    etUserId.setError("Invalid Email");

                    Toast.makeText(getApplicationContext(),"The Email should be atleast one special character",Toast.LENGTH_SHORT).show();
                }

               else if (!isValidPassword(pass)) {
                    etPassword.setError("Invalid Password");
                    Toast.makeText(getApplicationContext(),"The Password Morethan 6 characters",Toast.LENGTH_SHORT).show();

                }




                break;
            case R.id.tvForgotPassword:


                break;
            case R.id.tvReterivePassword:

                break;
        }
    }


    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }
}
