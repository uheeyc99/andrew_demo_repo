package com.andrew.contentprovider.demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "andrew_demo.db";
	private static final int DATABASE_VERSION=1;
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
    	// ´´½¨programmer±í
/*        db.execSQL("CREATE TABLE " + Provider.ProgrammerColumns.TABLE_NAME + " ("
                + ContentDefinition.UserTableData._ID + " INTEGER PRIMARY KEY,"
                + ContentDefinition.UserTableData.NAME + " TEXT,"
                + ContentDefinition.UserTableData.AGE + " INTEGER"
                + ");");*/
		db.execSQL("create table if not exists " + ContentDefinition.USERS_TABLE_NAME
				+ "(" + ContentDefinition.UserTableData._ID
				+ " INTEGER PRIMARY KEY autoincrement,"
				+ ContentDefinition.UserTableData.NAME + " varchar(20),"
				+ ContentDefinition.UserTableData.MARK + " varchar,"
				+ ContentDefinition.UserTableData.TITLE + " varchar(20),"
				+ ContentDefinition.UserTableData.DATE_ADDED + " long,"
				+ ContentDefinition.UserTableData.SEX + " boolean)" + ";");	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
