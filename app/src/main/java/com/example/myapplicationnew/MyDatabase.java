package com.example.myapplicationnew;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {


    public static final String DATABASE_NAME="abongaro.db";
    public static final int DATABASE_VERSION=1;

    public static final String NEWS_TABLE="news_table";

    public static final String COL_SL = "sl";
    public static final String COL_DATE="date";
    public static final String COL_TITLE="title";
    public static final String COL_MAIN_TEXT="text";
    public static final String COL_IMAGE = "image";
    public static final String COL_CATEGORY = "category";
    public static final String COL_TAGS = "tags";


    public static final String CREATE_TABLE="create table "+NEWS_TABLE+
            "(" +COL_SL+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +COL_DATE+ " TEXT, "
            +COL_TITLE+ " TEXT, "+COL_MAIN_TEXT+ " TEXT, "+ COL_IMAGE+ " INTEGER, "+COL_CATEGORY+
            " TEXT, "+COL_TAGS+ " TEXT "+ ")";

    public MyDatabase(@Nullable Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    /*public MyDatabase(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ NEWS_TABLE);
        this.onCreate(db);
    }
}
