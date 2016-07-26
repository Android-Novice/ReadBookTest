package com.yuqf.readbooktest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

//这里的内容提供器，可以在MyFirstApp中访问
public class BooksContentProvider extends ContentProvider {

    private static final UriMatcher um = new UriMatcher(UriMatcher.NO_MATCH);
    private SQLiteDatabase sqlite;
    private DatabaseHelper dbHelper;

    private static final String TableName = "books";
    private final int MatchCode = 1;

    @Override
    public boolean onCreate() {
        // TODO Auto-generated method stub
        um.addURI(Provider.Authority, "book", MatchCode);
        dbHelper = new DatabaseHelper(getContext());
        return dbHelper == null ? false : true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        // TODO Auto-generated method stub
        if (um.match(uri) == 1) {
            sqlite = dbHelper.getReadableDatabase();
            Cursor cursor = sqlite.query("books", new String[]{"id", "bookname", "id AS _id"}, null, null, null,
                    null, null);
            return cursor;
        }
        return null;
    }

    @Override
    public String getType(Uri uri) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO Auto-generated method stub
        if (um.match(uri) == 1) {
            sqlite = dbHelper.getWritableDatabase();
            sqlite.insert("books", null, values);
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // TODO Auto-generated method stub
        if (um.match(uri) == 1) {
            sqlite = dbHelper.getWritableDatabase();
            int retvalue = sqlite.update("books", values, selection, null);
            return retvalue;
        }
        return 0;
    }

    public class DatabaseHelper extends SQLiteOpenHelper {

        private String sqlStr = "CREATE table " + TableName
                + "([id] integer primary key autoincrement not null, [bookname] varchar(30) not null)";
        private String deleteSqlStr = "DROP TABLE IF EXISTS " + TableName;

        private static final String DB_Name = "testdb.db";
        private static final int DB_Version = 1;

        public DatabaseHelper(Context context) {
            super(context, DB_Name, null, DB_Version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(sqlStr);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            db.execSQL(deleteSqlStr);

            onCreate(db);
        }

    }

}
