package com.yuqf.readbooktest;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

/*当前demo的主要作用是 测试Intent的用法，*/

public class MainActivity extends AppCompatActivity {
    //public class MainActivity extends ActionBarActivity {
//public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//		getSupportActionBar().hide();
//        ActionBar actionBar = getActionBar();
//        if (actionBar != null)
//            actionBar.show();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        TextView textViewTitle = (TextView) findViewById(R.id.textview_title);
        textViewTitle.setText(R.string.app_name);

        Button btnBook = (Button) this.findViewById(R.id.btngetbook);
        btnBook.setOnClickListener(new ButtonClickListener());

        Button btninsert = (Button) this.findViewById(R.id.btninsertbook);
        btninsert.setOnClickListener(new ButtonClickListener());

        Button btnupdate = (Button) this.findViewById(R.id.btnupdatebook);
        btnupdate.setOnClickListener(new ButtonClickListener());

        Button btnFrameLayout = (Button) this.findViewById(R.id.btnframelayout);
        btnFrameLayout.setOnClickListener(new ButtonClickListener());

        Button btnLinearLayout = (Button) this.findViewById(R.id.btnlinearlayout);
        btnLinearLayout.setOnClickListener(new ButtonClickListener());

        Button btnTableLayout = (Button) findViewById(R.id.btntablelayout);
        btnTableLayout.setOnClickListener(new ButtonClickListener());

        Button btnAbsoluteLayout = (Button) findViewById(R.id.btnabsolutelayout);
        btnAbsoluteLayout.setOnClickListener(new ButtonClickListener());

        Button btnListView1 = (Button) findViewById(R.id.btnlistview1);
        btnListView1.setOnClickListener(new ButtonClickListener());

        Button btnListView2 = (Button) findViewById(R.id.btnlistview2);
        btnListView2.setOnClickListener(new ButtonClickListener());

        Button btnListView3 = (Button) findViewById(R.id.btnlistview3);
        btnListView3.setOnClickListener(new ButtonClickListener());

        Button btnListView4 = (Button) findViewById(R.id.btnlistview4);
        btnListView4.setOnClickListener(new ButtonClickListener());

        Button btnListView5 = (Button) findViewById(R.id.btnlistview5);
        btnListView5.setOnClickListener(new ButtonClickListener());

        Button btnListView6 = (Button) findViewById(R.id.btnlistview6);
        btnListView6.setOnClickListener(new ButtonClickListener());

        Button btnListView7 = (Button) findViewById(R.id.btnlistview7);
        btnListView7.setOnClickListener(new ButtonClickListener());

        Button btngv = (Button) findViewById(R.id.btngridview1);
        btngv.setOnClickListener(new ButtonClickListener());

        Button btnUIControl = (Button) findViewById(R.id.btnuicontrol1);
        btnUIControl.setOnClickListener(new ButtonClickListener());

        Button btnDialog = (Button) findViewById(R.id.btndialog);
        btnDialog.setOnClickListener(new ButtonClickListener());

        Button btnContentProvider = (Button) findViewById(R.id.btncontentprovider);
        btnContentProvider.setOnClickListener(new ButtonClickListener());

        Button btnSlidingDrawer = (Button) findViewById(R.id.btn_sliding_drawer);
        btnSlidingDrawer.setOnClickListener(new ButtonClickListener());

        Button btnSlidingPaneLayout = (Button) findViewById(R.id.btn_sliding_pane_layout);
        btnSlidingPaneLayout.setOnClickListener(new ButtonClickListener());

        Button btnDrawerLayout1 = (Button) findViewById(R.id.btn_drawer_layout_1);
        btnDrawerLayout1.setOnClickListener(new ButtonClickListener());

        Button btnDrawerLayout2 = (Button) findViewById(R.id.btn_drawer_layout_2);
        btnDrawerLayout2.setOnClickListener(new ButtonClickListener());

        Button btnFloatingWindow = (Button) findViewById(R.id.btn_floating_window);
        btnFloatingWindow.setOnClickListener(new ButtonClickListener());

        Button btnViewPager = (Button)findViewById(R.id.btn_view_pager);
        btnViewPager.setOnClickListener(new ButtonClickListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = null;
        switch (id) {
            case R.id.action_settings:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                break;
            case R.id.action_settings1:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:158158888851"));
                break;
            case R.id.action_settings2:// 这个展示有问题， 应该是展示当前联系人详情的，结果展示不出来
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/15213131512"));
                break;
            case R.id.action_settings3:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/高中政"));
                break;
            case R.id.action_settings4:
                intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("vnd.android.cursor.item/phone");
                // intent.setComponent();
                break;
        }
        this.startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    class ButtonClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.btngetbook:
                    TextView textviewBook = (TextView) findViewById(R.id.textview_showbooklist);
                    textviewBook.setText("");
                    Cursor cursor = getContentResolver().query(Provider.Book.BookUri, null, null, null, null);
                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(cursor.getColumnIndex("id"));
                        String name = cursor.getString(cursor.getColumnIndex("bookname"));
                        String curStr = String.format(Locale.getDefault(), "%d-%s\n", id, name);
                        String tvStr = textviewBook.getText().toString();
                        textviewBook.setText(tvStr + curStr);
                    }
                    cursor.close();
                    break;
                case R.id.btninsertbook:
                    for (int i = 0; i < 3; i++) {
                        ContentValues cv = new ContentValues();
                        switch (i) {
                            case 0:
                                cv.put("bookname", "亮剑");
                                break;
                            case 1:
                                cv.put("bookname", "亮剑book");
                                break;
                            case 2:
                                cv.put("bookname", "不亮剑");
                                break;
                        }
                        getContentResolver().insert(Provider.Book.BookUri, cv);
                    }
                    break;
                case R.id.btnupdatebook:
                    ContentValues updateCV = new ContentValues();
                    updateCV.put("bookname", "东方不亮西方亮");
                    getContentResolver().update(Provider.Book.BookUri, updateCV, "id=1", null);
                    break;
                case R.id.btnframelayout:
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, FrameLayoutActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnlinearlayout:
                    Intent intent1 = new Intent();
                    intent1.setClass(MainActivity.this, LinearLayoutActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.btntablelayout:
                    Intent intent2 = new Intent();
                    intent2.setClass(MainActivity.this, TableLayoutActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.btnabsolutelayout:
                    Intent intent3 = new Intent();
                    intent3.setClass(MainActivity.this, AbsoluteLayoutActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.btnlistview1:
                    Intent intent4 = new Intent();
                    intent4.setClass(MainActivity.this, ListViewActivity_1.class);
                    startActivity(intent4);
                    break;
                case R.id.btnlistview2:
                    Intent intent5 = new Intent();
                    intent5.setClass(MainActivity.this, ListViewActivity_2.class);
                    startActivity(intent5);
                    break;
                case R.id.btnlistview3:
                    Intent intent6 = new Intent();
                    intent6.setClass(MainActivity.this, ListViewActivity_3.class);
                    startActivity(intent6);
                    break;
                case R.id.btnlistview4:
                    Intent intent7 = new Intent();
                    intent7.setClass(MainActivity.this, ListViewActivity_4.class);
                    startActivity(intent7);
                    break;
                case R.id.btnlistview5:
                    Intent intent8 = new Intent();
                    intent8.setClass(MainActivity.this, ListViewActivity_5.class);
                    startActivity(intent8);
                    break;
                case R.id.btngridview1:
                    Intent intent9 = new Intent();
                    intent9.setClass(MainActivity.this, GridViewActivity_1.class);
                    startActivity(intent9);
                    break;
                case R.id.btnuicontrol1:
                    Intent intent10 = new Intent();
                    intent10.setClass(MainActivity.this, UIControlsActivity.class);
                    startActivity(intent10);
                    break;
                case R.id.btndialog:
                    Intent intent11 = new Intent();
                    intent11.setClass(MainActivity.this, DialogActivity.class);
                    startActivity(intent11);
                    break;
                case R.id.btnlistview6:
                    Intent intent12 = new Intent();
                    intent12.setClass(MainActivity.this, ListViewActivity_6.class);
                    startActivity(intent12);
                    break;
                case R.id.btnlistview7:
                    Intent intent13 = new Intent();
                    intent13.setClass(MainActivity.this, ListViewActivity_7.class);
                    startActivity(intent13);
                    break;
                case R.id.btncontentprovider:
                    Intent intent14 = new Intent();
                    intent14.setClass(MainActivity.this, MainNewActivity.class);
                    startActivity(intent14);
                    break;
                case R.id.btn_sliding_drawer:
                    Intent intent15 = new Intent();
                    intent15.setClass(MainActivity.this, SlidingDrawerActivity.class);
                    startActivity(intent15);
                    break;
                case R.id.btn_sliding_pane_layout:
                    Intent intent16 = new Intent();
                    intent16.setClass(MainActivity.this, SlidingPaneLayoutActivity.class);
                    startActivity(intent16);
                    break;
                case R.id.btn_drawer_layout_1:
                    Intent intent17 = new Intent();
                    intent17.setClass(MainActivity.this, FirstNavigationDrawerActivity.class);
                    startActivity(intent17);
                    break;
                case R.id.btn_drawer_layout_2:
                    Intent intent18 = new Intent();
                    intent18.setClass(MainActivity.this, SecondNavigationDrawerActivity.class);
                    startActivity(intent18);
                    break;
                case R.id.btn_floating_window:
                    if (windowManager == null)
                        initFloatingWindow();
                    showFloatingWindow();
                    break;
                case R.id.btn_view_pager:
                    Intent intent19 = new Intent();
                    intent19.setClass(MainActivity.this, ViewPagerActivity.class);
                    startActivity(intent19);
                    break;
            }
        }
    }

    private WindowManager windowManager;
    private WindowManager.LayoutParams windowLayoutParams;
    private LinearLayout layout;
    private int top;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        top = rect.top;
        Log.d("MainActivityLog", "Current Top: " + String.valueOf(top) + "___Left: " + String.valueOf(rect.left) + "___Right: " + String.valueOf(rect.right) + "___Bottom: " + String.valueOf(rect.bottom));
    }

    private void showFloatingWindow() {
        windowManager.addView(layout, windowLayoutParams);
        finish();
    }

    private void closeFloatingWindow() {
        windowManager.removeView(layout);
        finish();
    }

    private void initFloatingWindow() {
        windowManager = (WindowManager) getApplicationContext().getSystemService(WINDOW_SERVICE);
        windowLayoutParams = new WindowManager.LayoutParams();
        windowLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        windowLayoutParams.format = PixelFormat.RGBA_8888;
        windowLayoutParams.gravity = Gravity.CENTER;
        windowLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        windowLayoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        windowLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        View view = LayoutInflater.from(this).inflate(R.layout.gridviewitem, null);
        LinearLayout parentLayout = (LinearLayout) view.findViewById(R.id.floating_window_parent);
        parentLayout.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        parentLayout.setBackgroundColor(Color.WHITE);
        TextView textView = (TextView) view.findViewById(R.id.textview_gv2);
        textView.setText("苍老师大电影，即将上映，敬请期待！");
        textView.setVisibility(View.VISIBLE);
        TextView textView1 = (TextView) view.findViewById(R.id.textview_gv1);
        textView1.setVisibility(View.GONE);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(view);

        layout.setOnTouchListener(new View.OnTouchListener() {

            long lastClickTime;
            float startX;
            float startY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getRawX();
                float y = event.getRawY() - top;
                Log.d("MainActivityLog", "Current X: " + String.valueOf(x) + "___Current Y: " + String.valueOf(y));
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        Log.d("MainActivityLog", "Current Start X: " + String.valueOf(startX) + "___Current start Y: " + String.valueOf(startY));
                        if (System.currentTimeMillis() - lastClickTime < 300) {
                            closeFloatingWindow();
                        }
                        lastClickTime = System.currentTimeMillis();
                        break;
                    case MotionEvent.ACTION_BUTTON_PRESS:
                        break;
                    case MotionEvent.ACTION_UP:
                        windowLayoutParams.x = (int) (x - startX);
                        windowLayoutParams.y = (int) (y - startY);
                        Log.d("MainActivityLog", "Current new X: " + String.valueOf(x - startX) + "___Current start Y: " + String.valueOf(y - startY));
                        windowManager.updateViewLayout(layout, windowLayoutParams);

                        startX = startY = 0;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        windowLayoutParams.x = (int) (x - startX);
                        windowLayoutParams.y = (int) (y - startY);
                        Log.d("MainActivityLog", "Current new X: " + String.valueOf(x - startX) + "___Current start Y: " + String.valueOf(y - startY));
                        windowManager.updateViewLayout(layout, windowLayoutParams);
                        break;
                }
                return false;
            }
        });
    }
}
