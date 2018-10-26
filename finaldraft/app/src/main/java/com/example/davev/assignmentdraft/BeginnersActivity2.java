package com.example.davev.assignmentdraft;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//The purpose of this activity is to present the user with the key components of ERD's.
// It is considered to be the Beginners lesson for ERD's.
public class BeginnersActivity2 extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginners2);

        //Calling the setOnClickListener method defined below so the "Enough words, show me a video" button acts correctly.
        Button watchVideo = (Button) findViewById(R.id.watchvideo_beg);
        watchVideo.setOnClickListener(this);
        Button home = (Button) findViewById(R.id.home_beg);
        home.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        //Provides the intent behind the "Enough words, show me a video" button, which is invoked in the onCreate method.
        switch (view.getId()) {
            case R.id.watchvideo_beg:
                intent = new Intent(this, BegginersAPIpage.class);
                break;


            case R.id.home_beg:
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
//ERD overview content displayed to user sourced from https://searchdatamanagement.techtarget.com/definition/entity-relationship-diagram-ERD