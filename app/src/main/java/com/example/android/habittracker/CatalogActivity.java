package com.example.android.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.habittracker.data.PersonHabitDbHelper;

import static com.example.android.habittracker.data.HabitContract.DataEntry.BASKETBALL_HABIT;
import static com.example.android.habittracker.data.HabitContract.DataEntry.STUDY_HABIT;

public class CatalogActivity extends AppCompatActivity {

    private static final String TAG = CatalogActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonHabitDbHelper dbHelper = new PersonHabitDbHelper(this);

        dbHelper.insertData("Vearak", "Thach", 20, BASKETBALL_HABIT);
        dbHelper.insertData("Van", "Stanley", 25, STUDY_HABIT);

        Cursor cursor = dbHelper.readData();

        while(cursor.moveToNext()){
            Log.v(TAG,"Row"  + cursor.getInt(0) + " " + cursor.getInt(1) + " "
                    + cursor.getInt(2) + " " + cursor.getInt(3));
        }
    }
}
