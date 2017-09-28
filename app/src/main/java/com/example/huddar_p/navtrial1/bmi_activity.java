package com.example.huddar_p.navtrial1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class bmi_activity extends AppCompatActivity {

    Spinner spinnerHeight,spinnerWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_activity);

        spinnerHeight = (Spinner)findViewById(R.id.workoutSpinner);
        ArrayAdapter adapter_height = ArrayAdapter.createFromResource(this,R.array.heights_arrays,android.R.layout.simple_spinner_item);
        spinnerHeight.setAdapter(adapter_height);

        spinnerWeight = (Spinner)findViewById(R.id.spinnerWeight);
        ArrayAdapter adapter_weight = ArrayAdapter.createFromResource(this,R.array.weight_arrays,android.R.layout.simple_spinner_item);
        spinnerWeight.setAdapter(adapter_weight);

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

    public void onButtonClick(View v){

        EditText e_height = (EditText)findViewById(R.id.workoutDuration);
        EditText e_weight = (EditText)findViewById(R.id.weight);
        TextView result = (TextView)findViewById(R.id.resultBMI);

        if(e_height.getText().length()==0 || e_weight.getText().length()==0 )
        {
            Toast.makeText(this,"Please fill in all the details",Toast.LENGTH_SHORT).show();
        }
        else{

            float height = Float.parseFloat(e_height.getText().toString());
            float weight = Float.parseFloat(e_weight.getText().toString());
            float height_meters;
            float weight_kgs;
            switch(spinnerHeight.getSelectedItem().toString())
            {
                case "feet": height_meters = height * 0.3048f;
                    break;
                case "cms": height_meters = height/100;
                    break;
                case "meter": height_meters = height;
                    break;
                default : height_meters = height;
                    break;

            }
            switch(spinnerWeight.getSelectedItem().toString())
            {
                case "kgs": weight_kgs = weight;
                    break;
                case "pounds": weight_kgs = weight*0.453592f;
                    break;

                default : weight_kgs = weight;
                    break;
            }
            float bmi = weight_kgs/(height_meters*height_meters);
            result.setText("YOUR BMI is "+bmi);

        }


    }
}
