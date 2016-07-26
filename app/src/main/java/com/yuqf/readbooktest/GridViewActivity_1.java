package com.yuqf.readbooktest;

import android.support.v7.app.AppCompatActivity;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewActivity_1 extends AppCompatActivity {

	final String[] NameArray = { "联系人", "短信", "Android导读", "Android游戏指南", "通话记录", "陆小凤系列小说", "我告诉你所谓的三国", "你所不知道的Sky",
			"刀剑笑", "剑神一笑", "凤舞九天", "邮件", "图片", "香港指南", "肉蒲团3D", "大漠苍穹", "大漠苍狼", "封神榜", "流年不利", "落花流水", "风花雪月", "大大历险记",
			"雪山飞狐", "孤芳自赏", "天天向下", "夜未眠", "兽王fly100%自传", "Eclipse与Android" };

	private Handler msgHandler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 110) {
				Bundle curBundle = msg.getData();
				String curMsg = curBundle.getString("msg");
				new AlertDialog.Builder(GridViewActivity_1.this).setIcon(R.drawable.canglaoshi_30).setMessage(curMsg)
						.setTitle("提示").setPositiveButton("Fuckyou11", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				}).show();
			}
			super.handleMessage(msg);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview_1);

		List<HashMap<String, Object>> mapList = getData();
		GridView gv = (GridView) findViewById(R.id.gridview1);
		MyAdapter adapter = new MyAdapter(this, mapList);
		gv.setAdapter(adapter);

		gv.setOnItemClickListener(new OnItemClickListener() {

			String curMsg = Charset.defaultCharset().toString();

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub

				curMsg = "你点击的条目是" + (position + 1);
				String name = ((TextView) view.findViewById(R.id.textview_gv1)).getText().toString();
				curMsg = curMsg + "; 当前条目的名字是" + name;

				new AlertDialog.Builder(GridViewActivity_1.this).setIcon(R.drawable.canglaoshi_30).setMessage(curMsg)
						.setTitle("提示").setPositiveButton("Fuckyou", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				}).show();

				Bundle bundle = new Bundle();
				bundle.putString("msg", curMsg);
				Message message = new Message();
				message.setData(bundle);
				message.what = 110;
				msgHandler.sendMessage(message);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_view_activity_1, menu);
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

	private List<HashMap<String, Object>> getData() {
		List<HashMap<String, Object>> mapList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < NameArray.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			String imgName = String.format("d%d", i + 1);
			int resId = getResources().getIdentifier(imgName, "drawable", this.getPackageName());
			map.put("image", resId);
			map.put("name", NameArray[i]);
			mapList.add(map);
		}

		return mapList;
	}

	class MyAdapter extends BaseAdapter {

		public Context context;
		List<HashMap<String, Object>> mapList;

		public MyAdapter(Context context, List<HashMap<String, Object>> mapList) {
			this.context = context;
			this.mapList = mapList;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mapList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mapList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				LayoutInflater inflater = LayoutInflater.from(context);
				convertView = inflater.inflate(R.layout.gridviewitem, parent, false);
			}

			HashMap<String, Object> map = mapList.get(position);
			ImageView view = (ImageView) convertView.findViewById(R.id.imageview_gv1);
			view.setImageResource((Integer) map.get("image"));
			TextView textView = (TextView) convertView.findViewById(R.id.textview_gv1);
			textView.setText((String) map.get("name"));

			return convertView;
		}
	}

}
