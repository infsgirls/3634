package com.example.davev.assignmentdraft;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//The purpose of this activity is to present the user with the cardinality types for ERD's.
// It is considered to be the Intermediate lesson for ERD's.
public class IntermediateActivity2 extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate2);

        //Calling the setOnClickListener method defined below so the "Enough words, show me a video" button acts correctly.
        Button watchVideo = (Button) findViewById(R.id.btn_next_b1);
        watchVideo.setOnClickListener(this);
        Button home = (Button) findViewById(R.id.home_int);
        home.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent = null;

        //Provides the intent behind the "Enough words, show me a video" button, which is invoked in the onCreate method.
        switch (view.getId()) {
            case R.id.btn_next_b1:
                intent = new Intent(this, IntermediateAPIpage.class);
                break;

            case R.id.home_int:
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
//ERD Cardinality content displayed to user sourced from https://searchdatamanagement.techtarget.com/definition/entity-relationship-diagram-ERD