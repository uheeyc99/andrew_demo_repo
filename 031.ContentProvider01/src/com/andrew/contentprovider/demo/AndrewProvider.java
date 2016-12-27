package com.andrew.contentprovider.demo;




import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.net.Uri;
import android.text.TextUtils;

public class AndrewProvider extends ContentProvider{

	private DatabaseHelper dbOpenHelper=null;
	@Override
	public boolean onCreate() {
    	//这里会调用 DBOpenHelper的构造函数创建一个数据库；
    	CursorFactory factory = null;  // added by eric gao
        dbOpenHelper = new DatabaseHelper(this.getContext(), ContentDefinition.DATABASE_NAME,factory ,ContentDefinition.DATABASE_VERSION);
        return true; 
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		  
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();  
	    switch (ContentDefinition.UserTableData.uriMatcher.match(uri)) {  
	        case ContentDefinition.UserTableData.TEACHERS:  
	            return db.query(ContentDefinition.USERS_TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);  
	        case ContentDefinition.UserTableData.TEACHER:  
	            // 进行解析，返回值为10  
	            long personid = ContentUris.parseId(uri);  
	            String where = "_ID=" + personid;// 获取指定id的记录  
	            where += !TextUtils.isEmpty(selection) ? " and (" + selection + ")" : "";// 把其它条件附加上  
	            return db.query(ContentDefinition.USERS_TABLE_NAME, projection, where, selectionArgs, null, null, sortOrder);  
	        default:  
	            throw new IllegalArgumentException("Unknown URI " + uri);  
        }        
        
    
	}

	@Override
	public String getType(Uri uri) {
        switch (ContentDefinition.UserTableData.uriMatcher.match(uri)) {  
        case ContentDefinition.UserTableData.TEACHERS:  
            return ContentDefinition.UserTableData.CONTENT_TYPE;  
        case ContentDefinition.UserTableData.TEACHER:  
            return ContentDefinition.UserTableData.CONTENT_TYPE_ITME;  
        default:  
            throw new IllegalArgumentException("Unknown URI " + uri);  
    }  
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
    	//获得一个可写的数据库引用，如果数据库不存在，则根据onCreate的方法里创建；
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();  
        long id = 0;  
        
        switch (ContentDefinition.UserTableData.uriMatcher.match(uri)) {  
        
	        case ContentDefinition.UserTableData.TEACHERS:  
	            id = db.insert(ContentDefinition.USERS_TABLE_NAME, null, values);	// 返回的是不记录的行号(文档有错误)，主键为int，实际上就是主键值  
	            return ContentUris.withAppendedId(uri, id);  
	        case ContentDefinition.UserTableData.TEACHER:  
	            id = db.insert(ContentDefinition.USERS_TABLE_NAME, null, values); 
	            String path = uri.toString();  
	            return Uri.parse(path.substring(0, path.lastIndexOf("/"))+id); // 替换掉id  
	        default:  
	            throw new IllegalArgumentException("Unknown URI " + uri);  
        }
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		  
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();  
        int count = 0;  
        switch (ContentDefinition.UserTableData.uriMatcher.match(uri)) {  
	        case ContentDefinition.UserTableData.TEACHERS:  
	            count = db.delete(ContentDefinition.USERS_TABLE_NAME, selection, selectionArgs);  
	            break;  
	        case ContentDefinition.UserTableData.TEACHER:  
	            // 下面的方法用于从URI中解析出id，对这样的路径content://hb.android.teacherProvider/teacher/10  
	            // 进行解析，返回值为10  
	            long personid = ContentUris.parseId(uri);  
	            String where = "_ID=" + personid;	// 删除指定id的记录  
	            where += !TextUtils.isEmpty(selection) ? " and (" + selection + ")" : "";	// 把其它条件附加上  
	            count = db.delete(ContentDefinition.USERS_TABLE_NAME, where, selectionArgs);  
	            break;  
	        default:  
	            throw new IllegalArgumentException("Unknown URI " + uri);  
        }  
        db.close();  
        return count;  
    
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db = dbOpenHelper.getWritableDatabase(); 
        int count = 0;  
        switch (ContentDefinition.UserTableData.uriMatcher.match(uri)) {  
        
	        case ContentDefinition.UserTableData.TEACHERS:  
	            count = db.update(ContentDefinition.USERS_TABLE_NAME, values, selection, selectionArgs);  
	            break;  
	        case ContentDefinition.UserTableData.TEACHER:  
	            // 下面的方法用于从URI中解析出id，对这样的路径content://com.ljq.provider.personprovider/person/10  
	            // 进行解析，返回值为10  
	            long personid = ContentUris.parseId(uri);  
	            String where = "_ID=" + personid;// 获取指定id的记录  
	            where += !TextUtils.isEmpty(selection) ? " and (" + selection + ")" : "";// 把其它条件附加上  
	            count = db.update(ContentDefinition.USERS_TABLE_NAME, values, where, selectionArgs);  
	            break;  
	        default:  
	            throw new IllegalArgumentException("Unknown URI " + uri);  
        }  
        db.close();  
        return count;  
	}

}
