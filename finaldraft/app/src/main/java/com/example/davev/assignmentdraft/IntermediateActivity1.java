package com.example.davev.assignmentdraft;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//The purpose of this activity is to present the user with an initial overview of how to design ERD's.
// It is considered to be the Advanced lesson for ERD's.
public class IntermediateActivity1 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate1);

        //Calling the setOnClickListener method defined below so the "Next" button acts correctly.
        Button next_page = (Button) findViewById(R.id.btn_next_i1);
        next_page.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        Intent intent = null;

        //Provides the intent behind teh "Next" button, which is invoked in the onCreate method.
        switch (view.getId()) {
            case R.id.btn_next_i1:
                intent = new Intent(this, IntermediateActivity2.class);
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