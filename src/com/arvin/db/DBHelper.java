package com.arvin.db;

import android.content.Context;  
import android.database.sqlite.SQLiteDatabase;  
import android.database.sqlite.SQLiteOpenHelper;  
  
public class DBHelper extends SQLiteOpenHelper {  
  
    private static final String DATABASE_NAME = "cocoplay.db";  
    private static final int DATABASE_VERSION = 2;  
      
    public DBHelper(Context context) {  
        //CursorFactory设置为null,使用默认值  
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }  
  
    //数据库第一次被创建时onCreate会被调用  
    @Override  
    public void onCreate(SQLiteDatabase db) {  
        db.execSQL("CREATE TABLE IF NOT EXISTS mp3 ("
        		+ "id INTEGER PRIMARY KEY,"
        		+ "title VARCHAR,"
        		+ "url VARCHAR,"
        		+ "album VARCHAR,"
        		+ "album_id VARCHAR,"
        		+ "artist VARCHAR,"
        		+ "artist_id VARCHAR,"
        		+ "bookmark VARCHAR,"
        		+ "duration INTEGER,"
        		+ "sortLetters VARCHAR"
        		+ ");");  
    }  
  
    //如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade  
    @Override  
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
        db.execSQL("DROP TABLE mp3");  
        db.execSQL("CREATE TABLE IF NOT EXISTS mp3 ("
        		+ "id INTEGER PRIMARY KEY,"
        		+ "title VARCHAR,"
        		+ "url VARCHAR,"
        		+ "album VARCHAR,"
        		+ "album_id VARCHAR,"
        		+ "artist VARCHAR,"
        		+ "artist_id VARCHAR,"
        		+ "bookmark VARCHAR,"
        		+ "duration INTEGER,"
        		+ "sortLetters VARCHAR"
        		+ ");");  
    }  
}  
