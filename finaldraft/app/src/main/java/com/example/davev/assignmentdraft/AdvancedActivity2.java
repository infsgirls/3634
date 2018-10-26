package com.example.davev.assignmentdraft;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//The purpose of this activity is to present the user with tips on how to design effective ERD's.
// It is considered to be the Advanced lesson for ERD's.
public class AdvancedActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced2);

        //Calling the setOnClickListener method defined below so the "Enough words, show me a video" button acts correctly.
        Button watchVideo = (Button) findViewById(R.id.watchvideo_adv);
        Button home = (Button) findViewById(R.id.home_adv);
        home.setOnClickListener(this);
        watchVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        //Provides the intent behind the "Enough words, show me a video" button, which is invoked in the onCreate method.
        switch (view.getId()) {
            case R.id.watchvideo_adv:
                intent = new Intent(this, AdvancedAPIpage.class);
                break;

            case R.id.home_adv:
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
//ERD design content presented to user sourced from https://www.smartdraw.com/entity-relationship-diagram/