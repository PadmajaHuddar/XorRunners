package com.example.huddar_p.navtrial1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WaterIntake extends AppCompatActivity{

    Spinner weightSpinner,workoutSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightSpinner = (Spinner)findViewById(R.id.weightSpinner);
        ArrayAdapter adapter_weight = ArrayAdapter.createFromResource(this,R.array.weight_arrays,android.R.layout.simple_spinner_item);
        weightSpinner.setAdapter(adapter_weight);

        workoutSpinner = (Spinner)findViewById(R.id.workoutSpinner);
        ArrayAdapter adapter_workout = ArrayAdapter.createFromResource(this,R.array.workout_duration_arrays,android.R.layout.simple_spinner_item);
        workoutSpinner.setAdapter(adapter_workout);

        if(getSupportActionBar()!=null)
        {getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);};
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);

    }

    public void onCheckWaterIntakeButtonClick(View view){
        EditText e_weight = (EditText)findViewById(R.id.weight);
        EditText e_workoutDuration = (EditText)findViewById(R.id.workoutDuration);
        TextView t1 = (TextView)findViewById(R.id.textView);

        float weight = Float.parseFloat(e_weight.getText().toString());
        float workoutDuration = Float.parseFloat(e_workoutDuration.getText().toString());

        float weight_lbs;
        float workoutDuration_mins;

        switch(weightSpinner.getSelectedItem().toString())
        {
            case "kgs": weight_lbs = weight * 2.20462f;
                break;
            case "lbs": weight_lbs = weight ;
                break;
            default : weight_lbs = weight * 2.20462f;
                break;

        }
        switch(workoutSpinner.getSelectedItem().toString())
        {
            case "mins": workoutDuration_mins = workoutDuration;
                break;
            case "hrs": workoutDuration_mins = workoutDuration * 60;
                break;

            default : workoutDuration_mins = workoutDuration;
                break;
        }

        float waterIntake = (weight_lbs*2)/3 + (workoutDuration_mins/30)*12;    //In ounces
        waterIntake = waterIntake * 0.0295735f;                                 //In litres
        //t1.setText("Water Intake : "+waterIntake + " Litres");
        t1.setText(String.format( "Water Intake : %.2f Litres", waterIntake ));

    }
}