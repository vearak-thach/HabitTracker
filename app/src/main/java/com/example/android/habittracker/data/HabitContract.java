package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * API Contract for the Pets app.
 */
public final class HabitContract {

    //To prevent someone from accidentally instatiating the contract class.
    //give it an empty constructor.
    private HabitContract (){}

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class DataEntry implements BaseColumns{

        /**
         * Name of table for Habit tracker
         */
        public final static String TABLE_NAME = "person";

        /**
         * Unique ID number for the person (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * First Name of the person
         *
         * Type: TEXT
         */
        public final static String COLUMN_FIRST_NAME = "FirstName";

        /**
         * Last Name of the person
         *
         * Type: TEXT
         */
        public final static String COLUMN_LAST_NAME = "LastName";

        /**
         * Age of the person
         *
         * Type: INTEGER
         */
        public final static String COLUMN_AGE = "PersonAge";

        /**
         * Habit column
         *
         * Type: String
         *
         * Two values - Basketball or Study
         */
       public final static String COLUMN_HABIT = "Habit";

        /**
         * Basketball Habit value
         */
        public final static int BASKETBALL_HABIT = 1;

        /**
         * Study Habit value
         */
        public final static int STUDY_HABIT = 2;
    }

}
