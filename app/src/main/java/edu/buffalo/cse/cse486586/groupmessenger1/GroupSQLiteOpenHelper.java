package edu.buffalo.cse.cse486586.groupmessenger1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Chaitanya on 2/16/15.
 */
public class GroupSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String TABLE_KV = "key_value";

    public static final String KEY = "key";
    public static final String VALUE = "value";

    private static final String DATABASE_NAME = "group_messenger.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_KV + "(" + KEY
            + " integer primary key, " + VALUE
            + " text not null);";

    public GroupSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(GroupSQLiteOpenHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KV);
        onCreate(db);
    }

}
