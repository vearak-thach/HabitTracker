package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.data.HabitContract.DataEntry;

import static com.example.android.habittracker.data.HabitContract.DataEntry.COLUMN_AGE;
import static com.example.android.habittracker.data.HabitContract.DataEntry.COLUMN_FIRST_NAME;
import static com.example.android.habittracker.data.HabitContract.DataEntry.COLUMN_HABIT;
import static com.example.android.habittracker.data.HabitContract.DataEntry.COLUMN_LAST_NAME;
import static com.example.android.habittracker.data.HabitContract.DataEntry.TABLE_NAME;
import static com.example.android.habittracker.data.HabitContract.DataEntry._ID;


public class PersonHabitDbHelper extends SQLiteOpenHelper {

    /*Name of the database file name*/
    private static final String DATABASE_NAME = "habit.db";

    /*Database version. If you change the database version, it must be incremented*/
    private static final int DATABASE_VERSION= 1;

    public PersonHabitDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*Called to create a database*/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create a String that contains the SQL statement to create the person table
        String SQL_CREATE_PERSON_TABLE = "CREATE TABLE " + TABLE_NAME +
                "(" + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_FIRST_NAME + " TEXT NOT NULL, "
                + COLUMN_LAST_NAME + " TEXT NOT NULL, "
                + COLUMN_AGE + " INTEGER NOT NULL, "
                + COLUMN_HABIT + " INTEGER NOT NULL );";

        sqLiteDatabase.execSQL(SQL_CREATE_PERSON_TABLE);
    }

    public void insertData(String firstName, String lastName, int age, int habit){
        //Gets the database in write mode
        SQLiteDatabase db = getWritableDatabase();

        //Create a ContentValues object where column names are the keys,
        //and parameters will be hardcoded
        ContentValues values = new ContentValues();
        values.put(DataEntry.COLUMN_FIRST_NAME, firstName);
        values.put(DataEntry.COLUMN_LAST_NAME, lastName);
        values.put(DataEntry.COLUMN_AGE, age);
        values.put(DataEntry.COLUMN_HABIT, habit);

        // Insert a new row for habit in the database
        db.insert(TABLE_NAME, null, values);
    }

    public Cursor readData(){
        //For access
        //Create and/or open a database to read from it
        SQLiteDatabase db = getReadableDatabase();

        //Define a projection that specifies which columns from the database
        //you will actually use after this query.
        String[] projection ={
                DataEntry._ID,
                DataEntry.COLUMN_FIRST_NAME,
                DataEntry.COLUMN_LAST_NAME,
                DataEntry.COLUMN_AGE,
                DataEntry.COLUMN_HABIT
        };

        //Perform a query on the pets table
        Cursor cursor = db.query(
                DataEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }

    //Currently Database Version is hardcoded to 1
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int version, int oldVersion) {

    }
}
