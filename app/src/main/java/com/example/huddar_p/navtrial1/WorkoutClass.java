package com.example.huddar_p.navtrial1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huddar_p on 26-09-2017.
 */

public class WorkoutClass {
    private int ID;
    private int Level;
    private String Workout_Name;
    private int Workout_Count;
    public WorkoutClass()
    {

    }
    public WorkoutClass(int id,int level,String workout_name,int workout_count)
    {
        this.ID=id;
        this.Level=level;
        this.Workout_Name=workout_name;
        this.Workout_Count=workout_count;
    }

    public void setID(int id) {
        this.ID = id;
    }
    public void setWorkout_Count(int count) {
        this.Workout_Count = count;
    }
    public void setLevel(int level) {
        this.Level = level;
    }

    public void setWorkout_Name(String name) {
        this.Workout_Name = name;
    }

    public int getID() {
        return ID;
    }
    public int getLevel() {
        return Level;
    }
    public String getWorkout_Name() {
        return Workout_Name;
    }
    public int getWorkout_Count() {
        return Workout_Count;
    }

//    @Override
//    public String toString()
//    {
//        return ID + " " + Level + " " + Workout_Name + " " + Workout_Count;       //Displaying multiple data values
//    }
}
