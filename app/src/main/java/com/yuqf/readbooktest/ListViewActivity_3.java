package com.yuqf.readbooktest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.yuqf.readbooktest.CommonMethods.CommonUtils;

/**
 * 这个例子主要是说明：用SimpleAdapter填充Listview的方法，注意一下HashMap类
 **/

/** 这个例子主要是说明：以及测试OptionMenu、ContextMenu、子菜单 **/
public class ListViewActivity_3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_activity_3);

        SimpleAdapter adapter = new SimpleAdapter(this, CommonUtils.getData(), R.layout.textviewitem1,
                new String[]{"img", "title", "info"},
                new int[]{R.id.imageview1, R.id.textview_lv111, R.id.textview_lv112});
        ListView lv = (ListView) findViewById(R.id.listview3);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);

        // ActionBar actionbar = getSupportActionBar();
        ActionBar actionbar = getActionBar();
        actionbar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP, ActionBar.DISPLAY_HOME_AS_UP);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.optionmenuforlistview3, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        // if (id == R.id.action_settings) {
        // return true;
        switch (id) {
            case R.id.optionmenuitem1:
                Toast.makeText(ListViewActivity_3.this, "第一选项", 2000).show();
                break;
            case R.id.optionmenuitem2:
                Toast.makeText(ListViewActivity_3.this, "第二选项", 2000).show();
                break;
            case R.id.optionmenusubitem1:
                Toast.makeText(ListViewActivity_3.this, "第1子选项", 2000).show();
                break;
            case R.id.optionmenusubitem2:
                Toast.makeText(ListViewActivity_3.this, "第2子选项", 2000).show();
                break;
            case R.id.optionmenusubitem3:
                Toast.makeText(ListViewActivity_3.this, "第3子选项", 2000).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenuforlistview3, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.contextmenuitem1:
                Toast.makeText(ListViewActivity_3.this, "上下文菜单第一项", 2000).show();
                break;
            case R.id.contextmenuitem2:
                Toast.makeText(ListViewActivity_3.this, "上下文菜单第2项", 2000).show();
                break;
            case R.id.contextmenuitem3:
                Toast.makeText(ListViewActivity_3.this, "上下文菜单第3项", 2000).show();
                break;
            case R.id.contextmenuitem4:
                Toast.makeText(ListViewActivity_3.this, "上下文菜单第4项", 2000).show();
                break;
            case R.id.contextmenusubitem1:
                Toast.makeText(ListViewActivity_3.this, "上下文菜单第一子项", 2000).show();
                break;
            case R.id.contextmenusubitem2:
                Toast.makeText(ListViewActivity_3.this, "上下文菜单第2子项", 2000).show();
                break;
            case R.id.contextmenusubitem3:
                Toast.makeText(ListViewActivity_3.this, "上下文菜单第3子项", 2000).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
