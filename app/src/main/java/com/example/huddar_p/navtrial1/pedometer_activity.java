package com.example.huddar_p.navtrial1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pedometer_activity extends AppCompatActivity implements SensorEventListener, StepListener {

    private TextView pedoDisplay,pedoCalories,pedoDistance;
    private Button pedoStart;
    private Button pedoStop;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;

    //private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;
    private float calories_burnt,distance_walked_kms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer_activity);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        pedoDisplay = (TextView)findViewById(R.id.pedoDisplay);
        pedoCalories = (TextView)findViewById(R.id.pedoCalories);
        pedoDistance = (TextView)findViewById(R.id.pedoDistance);
        pedoStart = (Button) findViewById(R.id.pedoStart);
        pedoStop = (Button) findViewById(R.id.pedoStop);

        if(getSupportActionBar()!=null)
        {getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);};

        pedoStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numSteps = 0;
                sensorManager.registerListener(pedometer_activity.this, accel, SensorManager.SENSOR_DELAY_FASTEST);

            }
        });


        pedoStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                sensorManager.unregisterListener(pedometer_activity.this);

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        calories_burnt = numSteps/20f;
        distance_walked_kms = numSteps/1312.33595801f;
       // String distance= Double.toString(num)
        pedoCalories.setText(Float.toString(calories_burnt));
        pedoDistance.setText(distance_walked_kms+" kms");
        pedoDisplay.setText(Integer.toString(numSteps));
    }
}
//yeh pedometer ka main activity hai