package com.example.huddar_p.navtrial1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UserProfile extends AppCompatActivity {
    DBHelper db;
    TextView displayData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        db = new DBHelper(this);
        db.dropTable();
        db.createTable();
        db.addShop(new WorkoutClass(1,0,"JUMPING JACKS",15));
        db.addShop(new WorkoutClass(2,0,"STEP UPS",10));
        db.addShop(new WorkoutClass(3,0,"PUSH UPS",3));
        db.addShop(new WorkoutClass(4,0,"ABDOMINAL CRUNCHES",10));
        db.addShop(new WorkoutClass(5,0,"PLANK for 10 seconds",1));
        db.addShop(new WorkoutClass(6,1,"JUMPING JACKS",18));
        db.addShop(new WorkoutClass(7,1,"TRICEP DIPS",4));
        db.addShop(new WorkoutClass(8,1,"SQUATS",10));
        db.addShop(new WorkoutClass(9,1,"BIRD DOG",10));
        db.addShop(new WorkoutClass(10,1,"PLANK for 15 seconds",1));

        List<WorkoutClass> workoutList =  db.getAllWorkoutByLevel(1);



        //displayData.setText(workoutList.get(1).toString());



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
    public void initializeDatabase(){

    }
    public void onSubmit(View v)
    {
        Toast.makeText(this,"Submitted Successfully",Toast.LENGTH_SHORT).show();
    }
}
