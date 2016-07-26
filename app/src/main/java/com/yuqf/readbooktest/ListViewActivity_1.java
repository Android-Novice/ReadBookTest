package com.yuqf.readbooktest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.List;
import java.util.ArrayList;

import android.widget.ArrayAdapter;
import android.widget.ListView;

/**���������Ҫ��˵������ArrayAdapter���Listview�ķ���**/
public class ListViewActivity_1 extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview_activity_1);

		ListView lv1 = (ListView) findViewById(R.id.listview1);
		lv1.setAdapter(
				new ArrayAdapter<String>(this, R.layout.textviewitem1, R.id.textview_lv112, getData()));
		
//		ActionBar actionbar = getSupportActionBar();
//		actionbar.hide();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view_activity_1, menu);
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

	private List<String> getData() {
		List<String> strList = new ArrayList<String>();
		strList.add("�л����񹲺͹�");
		strList.add("�л����񹲺͹�1");
		strList.add("�л����񹲺͹�2");
		strList.add("�л����񹲺͹�3");
		strList.add("�л����񹲺͹�4");
		strList.add("�л����񹲺͹�5");
		strList.add("�л����񹲺͹�6");
		return strList;
	}
}
