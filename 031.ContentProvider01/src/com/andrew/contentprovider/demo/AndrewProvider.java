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
    	//�������� DBOpenHelper�Ĺ��캯������һ�����ݿ⣻
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
	            // ���н���������ֵΪ10  
	            long personid = ContentUris.parseId(uri);  
	            String where = "_ID=" + personid;// ��ȡָ��id�ļ�¼  
	            where += !TextUtils.isEmpty(selection) ? " and (" + selection + ")" : "";// ����������������  
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
    	//���һ����д�����ݿ����ã�������ݿⲻ���ڣ������onCreate�ķ����ﴴ����
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();  
        long id = 0;  
        
        switch (ContentDefinition.UserTableData.uriMatcher.match(uri)) {  
        
	        case ContentDefinition.UserTableData.TEACHERS:  
	            id = db.insert(ContentDefinition.USERS_TABLE_NAME, null, values);	// ���ص��ǲ���¼���к�(�ĵ��д���)������Ϊint��ʵ���Ͼ�������ֵ  
	            return ContentUris.withAppendedId(uri, id);  
	        case ContentDefinition.UserTableData.TEACHER:  
	            id = db.insert(ContentDefinition.USERS_TABLE_NAME, null, values); 
	            String path = uri.toString();  
	            return Uri.parse(path.substring(0, path.lastIndexOf("/"))+id); // �滻��id  
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
	            // ����ķ������ڴ�URI�н�����id����������·��content://hb.android.teacherProvider/teacher/10  
	            // ���н���������ֵΪ10  
	            long personid = ContentUris.parseId(uri);  
	            String where = "_ID=" + personid;	// ɾ��ָ��id�ļ�¼  
	            where += !TextUtils.isEmpty(selection) ? " and (" + selection + ")" : "";	// ����������������  
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
	            // ����ķ������ڴ�URI�н�����id����������·��content://com.ljq.provider.personprovider/person/10  
	            // ���н���������ֵΪ10  
	            long personid = ContentUris.parseId(uri);  
	            String where = "_ID=" + personid;// ��ȡָ��id�ļ�¼  
	            where += !TextUtils.isEmpty(selection) ? " and (" + selection + ")" : "";// ����������������  
	            count = db.update(ContentDefinition.USERS_TABLE_NAME, values, where, selectionArgs);  
	            break;  
	        default:  
	            throw new IllegalArgumentException("Unknown URI " + uri);  
        }  
        db.close();  
        return count;  
	}

}
