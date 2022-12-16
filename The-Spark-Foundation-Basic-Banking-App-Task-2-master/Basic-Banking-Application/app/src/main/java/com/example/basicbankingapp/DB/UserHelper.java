package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Aasif Ali', 'aa4571756@gmail.com','7584','03043411862', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Muzamil Ahmed', 'muzamil21@gmail.com','1258','03338380221', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Agha Haider', 'aghah880@gmail.com','8896','03012213330', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Fahad Umar', 'fumar554@gmail.com','7752','03022234332', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Noor Muhammad', 'noor44@gmail.com','3669','03055432008', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Anees', 'anees111@gmail.com','9985','03012232554', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Rafay Hussaim', 'rafay39@gmail.com','1207','03422433667', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Zubair Ahmed', 'zubair01@gmail.com','4522','03198336366', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Imran Khan', 'ikhan121gmail.com','6582','03158106753', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Sana', 'sana1010@gmail.com','5450','03055954771', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Sadia', 'sadia228@gmail.com','2656','03312710207', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Hussain', 'hussain@gmail.com','1203','03412191117', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Ali Murtaza', 'alim@gmail.com','5566','03234456998', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Ismail', 'is22@gmail.com','2236','03088766990', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Farhan', 'farhan332@gmail.com','6692','03348898221', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}