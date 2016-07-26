package com.yuqf.readbooktest;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yuqf.readbooktest.CommonMethods.CommonUtils;

/**这个例子主要是说明：用SimpleAdapter填充Listview的方法，注意一下HashMap类，并且Activity是从Activity开始的，
 * 还有就是GetApplicationContext()方法获取到的Context并不一定是对的**/
public class ListViewActivity_5 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview_activity_5);

		MyAdapter adapter = new MyAdapter(this);
		ListView lv = (ListView) findViewById(R.id.listview4);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Log.v("ItemCLick", "你点击的条目是" + position);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view_activity_5, menu);
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

	private void showInfo(String title, String message) {
		new AlertDialog.Builder(this).setIcon(R.drawable.canglaoshi_30).setTitle(title).setMessage(message)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				}).show();
	}

	final class ListViewItem {
		public TextView tvTitle;
		public TextView tvInfo;
		public ImageView ivIcon;
		public Button btnMore;
	}

	class MyAdapter extends BaseAdapter {

		private LayoutInflater inflater;
		private Context context;

		public MyAdapter(Context context) {
			inflater = LayoutInflater.from(context);
			this.context = context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return CommonUtils.getData().size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ListViewItem viewItem = null;
			if (convertView == null) {
				viewItem = new ListViewItem();

				convertView = inflater.inflate(R.layout.textviewitem2, null);
				viewItem.btnMore = (Button) convertView.findViewById(R.id.btnmore);
				viewItem.ivIcon = (ImageView) convertView.findViewById(R.id.imageview2);
				viewItem.tvTitle = (TextView) convertView.findViewById(R.id.textview_lv211);
				viewItem.tvInfo = (TextView) convertView.findViewById(R.id.textview_lv212);

				convertView.setTag(viewItem);

			} else {
				viewItem = (ListViewItem) convertView.getTag();
			}

			final String title = (String) CommonUtils.getData().get(position).get("title");
			final String info = (String) CommonUtils.getData().get(position).get("info");
			viewItem.ivIcon.setImageResource(R.id.none);
			viewItem.ivIcon.setBackgroundResource((Integer) CommonUtils.getData().get(position).get("img"));
			viewItem.tvTitle.setText(title);
			viewItem.tvInfo.setText(info);

			viewItem.btnMore.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					// new
					// AlertDialog.Builder(getApplicationContext()).setIcon(R.drawable.canglaoshi_30).setMessage(info)
					// .setTitle(title).setPositiveButton("Fuck you", new
					// DialogInterface.OnClickListener() {
					//
					// @Override
					// public void onClick(DialogInterface dialog, int which) {
					// // TODO Auto-generated method stub
					//
					// }
					// }).show();
					Context curContext = getApplicationContext();
					if (curContext == null)
						showInfo("竟然是空", "竟然是空");
					else if (curContext == context) {
						showInfo("竟然是相同的", "竟然是相同的");
					} else {
						showInfo("竟然是bu相同的", "竟然是bu相同的");
					}
					new AlertDialog.Builder(context).setIcon(R.drawable.canglaoshi_30).setTitle(title).setMessage(info)
							.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					}).show();

					// showInfo(title, info);
				}
			});
			return convertView;
		}

	}
}
