package com.example.m2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.sql.Blob;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Db5 ";
    public static final String TABLE_NAME = "pr4";


    public static final String KEY_ID = "_id";
    public static final String KEY_NAME_WORK = "name_work_t";
    public static final String KEY_FIO = "fio_t";
    public static final String KEY_PHONE = "phone_t";
    public static final String KEY_EMAIL = "email_t";
    public static final String KEY_FILE_URI = "file_uri_t";
    public static final String KEY_STATUS = "status";
    public static final String KEY_USER_ID = "user_id";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME_WORK + " text,"
                + KEY_FIO + " text,"
                + KEY_PHONE + " text,"
                + KEY_EMAIL + " text,"
                + KEY_FILE_URI + " text,"
                + KEY_STATUS +" text,"
                + KEY_USER_ID +" text"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }
}
