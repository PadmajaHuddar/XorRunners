package com.example.huddar_p.navtrial1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


public class hiit_activity extends AppCompatActivity {

    TextView displayData;
    TextView workoutTask;
    TextView countTask;
    public static WorkOutHelper wk;
    public static int user_level=0;
    public static int workout_index=0;

    GifImageView myGif;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiit_activity);

        db = new DBHelper(this);
        db.dropTable();
        db.createTable();
        db.addShop(new WorkoutClass(1,0,"JUMPING JACKS",15));
        db.addShop(new WorkoutClass(2,0,"MOUNTAIN CLIMBERS",10));
        db.addShop(new WorkoutClass(3,0,"PUSH UPS",3));
        db.addShop(new WorkoutClass(4,0,"SQUAT JUMPS",10));
        db.addShop(new WorkoutClass(5,0,"LUNGE JUMPS",10));
        db.addShop(new WorkoutClass(6,0,"SQUAT JUMPS",18));
        db.addShop(new WorkoutClass(7,0,"PUSH UPS",7));
        db.addShop(new WorkoutClass(8,0,"LUNGE JUMPS",15));
        db.addShop(new WorkoutClass(9,0,"JUMPING JACKS",15));
        db.addShop(new WorkoutClass(10,0,"MOUNTAIN CLIMBERS",18));


        displayData = (TextView) findViewById(R.id.textView5);

        if(getSupportActionBar()!=null)
        {getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);};


        //wk=new WorkOutHelper();
        workoutTask = (TextView)findViewById(R.id.workoutTask);
        countTask =  (TextView)findViewById(R.id.countTask);
        //workoutTask.setText(wk.workout_array[user_level].workout_count[workout_index]+ " "+wk.workout_array[user_level].workout_type[workout_index]);
        List<WorkoutClass> workoutList =  db.getAllWorkoutByLevel(user_level);
        workoutTask.setText(workoutList.get(workout_index).getWorkout_Name());
        countTask.setText("COUNT: "+Integer.toString(workoutList.get(workout_index).getWorkout_Count()));
        try
        {

            GifDrawable gifLondonBridgePlank = new GifDrawable( getResources(), R.drawable.london_bridge_plank);
            GifDrawable gifLungeJump = new GifDrawable( getResources(), R.drawable.ezgif);
            GifDrawable gifMountainClimber = new GifDrawable( getResources(), R.drawable.mountain_climber);
            GifDrawable gifPlank = new GifDrawable( getResources(), R.drawable.plank);
            GifDrawable gifJumpingJack = new GifDrawable( getResources(), R.drawable.jumpingjack);
            GifDrawable gifPushUp = new GifDrawable( getResources(), R.drawable.pushup);
            GifDrawable gifSpidermanPlank = new GifDrawable( getResources(), R.drawable.spiderman_plank);
            GifDrawable gifSquatJump = new GifDrawable( getResources(), R.drawable.squat_jump);
            GifDrawable gifStepUp = new GifDrawable( getResources(), R.drawable.step_up);
            GifDrawable gifAbc = new GifDrawable( getResources(), R.drawable.abc);

            myGif = (GifImageView)findViewById(R.id.gif1);

            switch(workoutList.get(workout_index).getWorkout_Name())
            {
                case "JUMPING JACKS":   myGif.setImageDrawable(gifJumpingJack);
                    break;
                case "PUSH UPS":   myGif.setImageDrawable(gifPushUp);
                                   break;
                case "MOUNTAIN CLIMBERS":    myGif.setImageDrawable(gifMountainClimber);
                    break;
                case "LUNGE JUMPS":    myGif.setImageDrawable(gifLungeJump);
                    break;
                case "SQUAT JUMPS":    myGif.setImageDrawable(gifSquatJump);
                    break;
                case "STEP UPS":    myGif.setImageDrawable(gifStepUp);
                    break;

                default :   myGif.setImageDrawable(gifAbc);
                            break;

            }


        }
        catch(Exception e){

        }
    }

    public void onButtonClick(View v){
        if(workout_index<10 && user_level < 2) {
            workout_index++;
        }
        else if(workout_index == 10 && user_level < 2){
            user_level++;
            workout_index=0;
        }
        if(user_level < 2 ){
            Intent myIntent = new Intent(hiit_activity.this,TimerClass.class);
            startActivity(myIntent);
        }
        else
        {
            Intent myIntent = new Intent(hiit_activity.this,MainActivity.class);
            startActivity(myIntent);
        }

    }












    public boolean onOptionsItemSelected(MenuItem item)
    {
       // if(item.getItemId()==android.R.id.home)
         //   finish();
        Intent homePage= new Intent(hiit_activity.this,MainActivity.class);
        startActivity(homePage);
        return super.onOptionsItemSelected(item);

    }
}
