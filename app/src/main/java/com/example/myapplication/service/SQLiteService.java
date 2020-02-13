package com.example.myapplication.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Objects;

public class SQLiteService extends SQLiteOpenHelper {

    private static final String TAG = "SQLiteService";
    private static final String DATABASE_NAME = "Demo_Database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE = "best_score";
    private static final String _ID ="_Id";
    private static final String COLUMN_SCORE ="score";

    public SQLiteService(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "SQLiteService.onCreate ... ");
        db.execSQL("CREATE TABLE " + TABLE + "(" + _ID + " INTEGER PRIMARY KEY, " + COLUMN_SCORE + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "SQLiteService.onUpdate ... ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    private void addDefaultScore() {
            Log.i(TAG, "Attempt write data to database");
        try(SQLiteDatabase db = getWritableDatabase()) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_SCORE, 0);
            db.insert(TABLE, null, values);
            Log.i(TAG, "Attempt write data to database - successfully");
        } catch (SQLiteException e) {
            Log.d(TAG, "Attempt write data to database - failed\n" + e.getMessage());
        }

    }

    public int get() {
            Log.i(TAG, "Attempt to get score");
        try (SQLiteDatabase db = this.getReadableDatabase();
             Cursor cursor = db.query(TABLE, new String[]{_ID, COLUMN_SCORE}, _ID + "=?",
                     new String[]{String.valueOf(1)}, null, null, null, null)){
            if (cursor != null) {
                cursor.moveToFirst();
            }
            Log.i(TAG, "Attempt to get score - success");
            return Objects.requireNonNull(cursor).getInt(1);
        } catch (Exception ignored){
            addDefaultScore();
            Log.i(TAG, "Attempt to get score - failed\n" +
                    "Set to default value");
        }
        return 0;
    }

    public void update(int score) {
            Log.i(TAG, "Attempt to update");
        try (SQLiteDatabase db = this.getWritableDatabase()){
            ContentValues values = new ContentValues();
            values.put(COLUMN_SCORE, score);
            db.update(TABLE, values, _ID + " = ?", new String[]{String.valueOf(1)});
            Log.i(TAG, "Attempt to update - successful");
        } catch (Exception e) {
            Log.d(TAG, "Attempt to update - failed\n" + e.getMessage());
        }
    }
}
