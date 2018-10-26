package com.example.davev.assignmentdraft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

//This activity is the main activity that a user will see once the app is run. It is the "Home" page of the
//application, and will be the initial touchpoint for any user experience.
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getStarted = (Button) findViewById(R.id.getStarted);
        getStarted.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            //"Let's Get Started" button to launch Dashboard where user can select a course option
            case R.id.getStarted:
                intent = new Intent(this, Dashboard.class);
                break;

            default:

        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}


//Code generated based on tutorials at https://www.udemy.com/master-android-7-nougat-java-app-development-step-by-step/  [Developed by Tim Buchalka]