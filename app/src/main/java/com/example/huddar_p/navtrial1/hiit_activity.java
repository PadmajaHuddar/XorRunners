package com.example.huddar_p.navtrial1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class hiit_activity extends AppCompatActivity {

    TextView workoutTask;
    public static WorkOutHelper wk;
    public static int user_level=0;
    public static int workout_index=0;
    GifImageView myGif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiit_activity);
        if(getSupportActionBar()!=null)
        {getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);};

        wk=new WorkOutHelper();
        workoutTask = (TextView)findViewById(R.id.workoutTask);
        workoutTask.setText(wk.workout_array[user_level].workout_count[workout_index]+ " "+wk.workout_array[user_level].workout_type[workout_index]);
        try
        {

            GifDrawable gifLondonBridgePlank = new GifDrawable( getResources(), R.drawable.london_bridge_plank);
          //  GifDrawable gifLungeJump = new GifDrawable( getResources(), R.drawable.lunge_jump);
            GifDrawable gifLungeJump = new GifDrawable( getResources(), R.drawable.ezgif);
            GifDrawable gifMountainClimber = new GifDrawable( getResources(), R.drawable.mountain_climber);
            GifDrawable gifPlank = new GifDrawable( getResources(), R.drawable.plank);
            GifDrawable gifPlankJack = new GifDrawable( getResources(), R.drawable.plank_jack);
            GifDrawable gifPushUp = new GifDrawable( getResources(), R.drawable.pushup);
            GifDrawable gifSpidermanPlank = new GifDrawable( getResources(), R.drawable.spiderman_plank);
            GifDrawable gifSquatJump = new GifDrawable( getResources(), R.drawable.squat_jump);
            GifDrawable gifStepUp = new GifDrawable( getResources(), R.drawable.step_up);
            GifDrawable gifAbc = new GifDrawable( getResources(), R.drawable.abc);

            myGif = (GifImageView)findViewById(R.id.gif1);

            switch(wk.workout_array[user_level].workout_type[workout_index]){

                case "push ups":    myGif.setImageDrawable(gifSpidermanPlank);
                                   break;
                case "mountain climbers":    myGif.setImageDrawable(gifSpidermanPlank);
                    break;
                case "lunge jumps":    myGif.setImageDrawable(gifSpidermanPlank);
                    break;
                case "squat jumps":    myGif.setImageDrawable(gifSquatJump);
                    break;
                case "step ups":    myGif.setImageDrawable(gifStepUp);
                    break;

                default :   myGif.setImageDrawable(gifAbc);
                            break;

            }


        }
        catch(Exception e){

        }
    }

    public void onButtonClick(View v){
        if(workout_index<2 && user_level < 2) {
            workout_index++;
        }
        else if(workout_index == 2 && user_level < 2){
            user_level++;
            workout_index=0;
        }
        if(user_level < 2 ){
            Intent myIntent = new Intent(hiit_activity.this,TimerClass.class);
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
