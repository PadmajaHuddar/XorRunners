package com.example.huddar_p.navtrial1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huddar_p on 26-09-2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "WorkoutDB";
    // Contacts table name
    private static final String TABLE_NAME = "workout_types";
    // Shops Table Columns names
    private static final String KEY_ID = "ID";
    private static final String KEY_LEVEL = "Level";
    private static final String KEY_WORKOUT_NAME = "Workout_Name";
    private static final String KEY_WORKOUT_COUNT = "Workout_Count";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LEVEL + " INTEGER,"
                + KEY_WORKOUT_NAME + " TEXT,"
                + KEY_WORKOUT_COUNT + " INTEGER"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
// Creating tables again
        onCreate(db);
    }
    // Adding new shop
    public void addShop(WorkoutClass workout) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, workout.getID()); // workout id
        values.put(KEY_LEVEL, workout.getLevel());//workout level
        values.put(KEY_WORKOUT_NAME, workout.getWorkout_Name()); // workout name
        values.put(KEY_WORKOUT_COUNT, workout.getWorkout_Count()); // workout count

// Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public void createTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LEVEL + " INTEGER,"
                + KEY_WORKOUT_NAME + " TEXT,"
                + KEY_WORKOUT_COUNT + " INTEGER"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    public void dropTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    // Getting one shop
    public WorkoutClass getWorkout(int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID = "+  id , null);
        if (cursor != null)
            cursor.moveToFirst();

        WorkoutClass workout_record = new WorkoutClass(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), cursor.getString(2),Integer.parseInt(cursor.getString(3)));
// return workout
        return workout_record;
    }

    // Getting All WorkoutClasss
    public List<WorkoutClass> getAllWorkoutByLevel(int level) {
        List<WorkoutClass> workoutList = new ArrayList<WorkoutClass>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME +" WHERE " + KEY_LEVEL + " = " + level ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                WorkoutClass workout = new WorkoutClass();
                workout.setID(Integer.parseInt(cursor.getString(0)));
                workout.setLevel(Integer.parseInt(cursor.getString(1)));
                workout.setWorkout_Name(cursor.getString(2));
                workout.setWorkout_Count(Integer.parseInt(cursor.getString(3)));
// Adding contact to list
                workoutList.add(workout);
            } while (cursor.moveToNext());
        }

// return contact list
        return workoutList;
    }

}
