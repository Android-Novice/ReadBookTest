package com.yuqf.readbooktest;

import java.util.HashMap;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuqf.readbooktest.CommonMethods.CommonUtils;

/**
 * 这个例子主要是说明：用SimpleAdapter填充Listview的方法，注意一下HashMap类，并且Activity是从ListActivity开始的
 **/
public class ListViewActivity_4 extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_activity_4);

        List<HashMap<String, Object>> mapList = CommonUtils.getData();
        MyAdapter adapter = new MyAdapter(mapList);

        ListView lv = getListView();
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view_activity_4, menu);
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

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        if (v != null) {
            Toast.makeText(this, ((TextView) v.findViewById(R.id.textview_lv211)).getText().toString(), 4000).show();
        }
    }

    final class ListViewItem {
        public TextView tvTitle;
        public TextView tvInfo;
        public ImageView ivIcon;
        public Button btnMore;
    }

    class MyAdapter extends BaseAdapter {

        private List<HashMap<String, Object>> mapList;

        public MyAdapter(List<HashMap<String, Object>> mapList) {
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
            return getListView().getItemIdAtPosition(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ListViewItem viewItem = null;
            if (convertView == null) {
                viewItem = new ListViewItem();

                convertView = getLayoutInflater().inflate(R.layout.textviewitem2, null);
                viewItem.btnMore = (Button) convertView.findViewById(R.id.btnmore);
                viewItem.ivIcon = (ImageView) convertView.findViewById(R.id.imageview2);
                viewItem.tvTitle = (TextView) convertView.findViewById(R.id.textview_lv211);
                viewItem.tvInfo = (TextView) convertView.findViewById(R.id.textview_lv212);

                convertView.setTag(viewItem);

            } else {
                viewItem = (ListViewItem) convertView.getTag();
            }

            final String title = (String) mapList.get(position).get("title");
            final String info = (String) mapList.get(position).get("info");
            viewItem.ivIcon.setImageResource(R.id.none);
            viewItem.ivIcon.setBackgroundResource((Integer) mapList.get(position).get("img"));
            viewItem.tvTitle.setText(title);
            viewItem.tvInfo.setText(info);

            viewItem.btnMore.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    new AlertDialog.Builder(getApplicationContext()).setIcon(R.drawable.canglaoshi_30).setMessage(info)
                            .setTitle(title).setPositiveButton("Fuck you", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub

                        }
                    }).show();
                }
            });
            return convertView;
        }

    }
}
