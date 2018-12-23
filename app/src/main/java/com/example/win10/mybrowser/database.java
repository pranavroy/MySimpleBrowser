package com.example.win10.mybrowser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by win10 on 7/26/2018.
 */
public class database extends SQLiteOpenHelper {
    public static final String databasename="history.db";
    public static final String tablename="historytable";
    public static final String col1="link";

    public database(Context context) {
        super(context, databasename, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tablename+"(LINK TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST "+tablename);
        onCreate(db);
    }
    public boolean insertdata(String link){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col1,link);

        long result=db.insert(tablename,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+tablename,null);
        return res;
    }
}
