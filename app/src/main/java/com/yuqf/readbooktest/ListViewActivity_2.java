package com.yuqf.readbooktest;

import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.ListView;

/**这个例子主要是说明：用SimpleCursorAdapter填充Listview的方法**/
public class ListViewActivity_2 extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview_activity_2);

		Cursor cursor = getContentResolver().query(Provider.Book.BookUri, null, null, null, null);
		startManagingCursor(cursor);

//		TextView textviewBook = (TextView) findViewById(R.id.textview_lv22);
//
//		while (cursor.moveToNext()) {
//			int id = cursor.getInt(cursor.getColumnIndex("id"));
//			String name = cursor.getString(cursor.getColumnIndex("bookname"));
//			String curStr = String.format(Locale.getDefault(), "%d-%s\n", id, name);
//			String tvStr = textviewBook.getText().toString();
//			textviewBook.setText(tvStr + curStr);
//		}
		String firstColumnName = cursor.getColumnName(0);
		String secondColumnName = cursor.getColumnName(1);

		ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.textviewitem1, cursor,
				new String[] { firstColumnName, secondColumnName }, new int[] { R.id.textview_lv111, R.id.textview_lv112 },
//				new String[] { secondColumnName }, new int[] { R.id.textview_lv112 },
				CursorAdapter.FLAG_AUTO_REQUERY);
		ListView lv = (ListView) findViewById(R.id.listview2);
		lv.setAdapter(adapter);
//		cursor.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view_activity_2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
