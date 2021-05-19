package com.example.myapplicationnew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MyDatabaseSource {

    MyDatabase myDatabase;
    SQLiteDatabase sqLiteDatabase;
   // AuditModel auditModel;

    public MyDatabaseSource(Context context)
    {
        myDatabase=new MyDatabase(context);

    }

    public void open()
    {
        sqLiteDatabase=myDatabase.getWritableDatabase();
    }
    public void close()
    {
        myDatabase.close();
    }

    public boolean addNews(NewsModel newsModel) {
        this.open();
        ContentValues contentValues=new ContentValues();
        contentValues.put(MyDatabase.COL_DATE,newsModel.getSdate());
        contentValues.put(MyDatabase.COL_TITLE,newsModel.getTitle());
        contentValues.put(MyDatabase.COL_MAIN_TEXT,newsModel.getText());
        contentValues.put(MyDatabase.COL_IMAGE,newsModel.getImage());
        contentValues.put(MyDatabase.COL_CATEGORY,newsModel.getCategory());
        contentValues.put(MyDatabase.COL_TAGS,newsModel.getTags());


        /*contentValues.put(StudentDatabase.COL_NAME,studentModel.getName());
        contentValues.put(StudentDatabase.COL_AGE,studentModel.getAge());
        contentValues.put(StudentDatabase.COL_ADRESS,studentModel.getAdress());*/
        Long insertedRow= sqLiteDatabase.insert(MyDatabase.NEWS_TABLE,null,contentValues);
        this.close();


        if (insertedRow>0)
        {
            return true;
        }else return false;
    }

    public ArrayList<NewsModel> getallNews() {
        this.open();
        ArrayList<NewsModel> arrayList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(MyDatabase.NEWS_TABLE, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {

                int sl = cursor.getInt(cursor.getColumnIndex(myDatabase.COL_SL));;
                String date=cursor.getString(cursor.getColumnIndex(myDatabase.COL_DATE));
                String title = cursor.getString(cursor.getColumnIndex(myDatabase.COL_TITLE));
                String maintext = cursor.getString(cursor.getColumnIndex(myDatabase.COL_MAIN_TEXT));
                int image=cursor.getInt(cursor.getColumnIndex(myDatabase.COL_IMAGE));
                String category=cursor.getString(cursor.getColumnIndex(myDatabase.COL_CATEGORY));
                String tags=cursor.getString(cursor.getColumnIndex(myDatabase.COL_TAGS));


              /*  String name = cursor.getString(cursor.getColumnIndex(auditDatabase.COL_NAME));
                Integer age = cursor.getInt(cursor.getColumnIndex(auditDatabase.COL_AGE));
                String adress = cursor.getString(cursor.getColumnIndex(auditDatabase.COL_ADRESS));
                Integer id=cursor.getInt(cursor.getColumnIndex(auditDatabase.COL_ID));*/

                NewsModel newsModel = new NewsModel(sl,date, title,maintext,image,
                        category,tags);
                arrayList.add(newsModel);

            } while (cursor.moveToNext());
        }
        this.close();
        cursor.close();
        return arrayList;
    }
}
