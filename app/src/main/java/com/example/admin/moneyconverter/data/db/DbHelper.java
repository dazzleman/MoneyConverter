package com.example.admin.moneyconverter.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "android.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_VALCURS_TABLE = "valcurs";
    private static final String DATABASE_VALUTE_TABLE = "valute";

    private static final String VALCURS_COLUMN_ID = "_id";
    private static final String VALCURS_COLUMN_NAME = "NAME";
    private static final String VALCURS_COLUMN_DATE = "DATE";

    private static final String VALUTE_COLUMN_ID = "_id";
    private static final String VALUTE_COLUMN_NAME = "NAME";
    private static final String VALUTE_COLUMN_VALUE = "VALUE";
    private static final String VALUTE_COLUMN_NOMINAL = "NOMINAL";
    private static final String VALUTE_COLUMN_CHARCODE = "CHARCODE";
    private static final String VALUTE_COLUMN_NUMCODE = "NUMCODE";
    private static final String VALUTE_COLUMN_VALCURS_ID = "VALCURS_ID";

    private static final String DATABASE_VALCURS_CREATE = "create table "
            + DATABASE_VALCURS_TABLE + "("
            + VALCURS_COLUMN_ID + " integer primary key autoincrement, "
            + VALCURS_COLUMN_NAME + " text not null, "
            + VALCURS_COLUMN_DATE + " text not null" + ");";

    private static final String DATABASE_VALUTE_CREATE = "create table "
            + DATABASE_VALUTE_TABLE + "("
            + VALUTE_COLUMN_ID + " integer primary key autoincrement, "
            + VALUTE_COLUMN_NAME + " text not null, "
            + VALUTE_COLUMN_VALUE + " real not null,"
            + VALUTE_COLUMN_NOMINAL + " integer not null, "
            + VALUTE_COLUMN_CHARCODE + " text not null, "
            + VALUTE_COLUMN_NUMCODE + " integer not null, "
            + VALUTE_COLUMN_VALCURS_ID + " integer not null" + ");";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_VALCURS_CREATE);
        db.execSQL(DATABASE_VALUTE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS table1");
        onCreate(db);
    }

    public long addValuteToTable(String name, double value, int nominal, String charCode, int numCode, long idValCurs) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues initialValues = createValuteContentValues(name, value, nominal, charCode, numCode, idValCurs);
        long row = db.insert(DATABASE_VALUTE_TABLE, null, initialValues);
        db.close();
        return row;
    }

    private ContentValues createValuteContentValues(String name, double value, int nominal, String charCode, int numCode, long idValCurs) {
        ContentValues values = new ContentValues();
        values.put(VALUTE_COLUMN_NAME, name);
        values.put(VALUTE_COLUMN_VALUE, value);
        values.put(VALUTE_COLUMN_NOMINAL, nominal);
        values.put(VALUTE_COLUMN_CHARCODE, charCode);
        values.put(VALUTE_COLUMN_NUMCODE, numCode);
        values.put(VALUTE_COLUMN_VALCURS_ID, idValCurs);
        return values;
    }

    public long addValCursToTable(String name, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues initialValues = createValCursContentValues(name, date);
        long row = db.insert(DATABASE_VALCURS_TABLE, null, initialValues);
        db.close();
        return row;
    }

    private ContentValues createValCursContentValues(String name, String date) {
        ContentValues values = new ContentValues();
        values.put(VALCURS_COLUMN_NAME, name);
        values.put(VALCURS_COLUMN_DATE, date);
        return values;
    }
}
