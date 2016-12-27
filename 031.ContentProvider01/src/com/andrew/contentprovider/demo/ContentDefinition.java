package com.andrew.contentprovider.demo;

import android.content.UriMatcher;
import android.provider.BaseColumns;


public class ContentDefinition {

	public static final String AUTHORITY = "com.andrew.contentprovider.eric_authorty_1";
	public static final String DATABASE_NAME = "people.db";
	public static final int DATABASE_VERSION = 5;
	public static final String USERS_TABLE_NAME = "teacher1";
	
	public static final class UserTableData implements BaseColumns {
		//public static final String TABLE_NAME = "teacher2";
		//Uri���ⲿ������Ҫ���ʾ���ͨ�����Uri���ʵģ����Uri�����Ψһ�ġ�
		
		// ���ݼ���MIME�����ַ�����Ӧ����vnd.android.cursor.dir/��ͷ  
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/eric_teachers";
		// ��һ���ݵ�MIME�����ַ���Ӧ����vnd.android.cursor.item/��ͷ  
		public static final String CONTENT_TYPE_ITME = "vnd.android.cursor.item/eric_teacher";
		/* �Զ���ƥ���� */  
	    public static final int TEACHERS = 1;  
	    /* �Զ���ƥ���� */  
	    public static final int TEACHER = 2;  
	    
		public static final String TITLE = "title";
		public static final String NAME = "name";
		public static final String AGE = "age";
		public static final String DATE_ADDED = "date_added";
		public static final String SEX = "sex";
		public static final String MARK = "mark";
		public static final String DEFAULT_SORT_ORDER = "_id desc";
		
		public static final UriMatcher uriMatcher;  
		
	    static {  
	        // ����UriMatcher.NO_MATCH��ʾ��ƥ���κ�·���ķ�����  
	        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);  
	        // ���match()����ƥ��content://hb.android.teacherProvider/teachern·��,����ƥ����ΪTEACHERS  
	        uriMatcher.addURI(ContentDefinition.AUTHORITY, "path1", TEACHERS);  
	        // ���match()����ƥ��content://hb.android.teacherProvider/teacher/230,·��������ƥ����ΪTEACHER  
	        uriMatcher.addURI(ContentDefinition.AUTHORITY, "path1/#", TEACHER);  
	    }
	}

}
