package org.androidtown.test_listview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 1hk_s on 2018-06-05.
 */


//버전관리
public class DatebaseHelper extends SQLiteOpenHelper {

    public String TAG = "DatebaseHelper";

    public DatebaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //처음 데이터베이스가 만들어질 경우 호출
    @Override
    public void onCreate(SQLiteDatabase db) {
        String name = "customer";
        //결과값을 받지않아도되는 쿼리문 입력시 사용
        String sql = "create table if not exists " + name + "(_id integer PRIMARY KEY autoincrement, name text, age integer, mobile text)";
        db.execSQL(sql);
        Log.d(TAG, "테이블 생성됨");

    }

    //기존에 사용하던 버전이 있어 업그레이드 할 경우 호출
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG,"onUpgrade 호출됨 : " +oldVersion+ ", "+ newVersion);

        if(newVersion > 1){
            String tableName = "customer";
            db.execSQL("drop table if exists" + tableName);
        }
    }
}
