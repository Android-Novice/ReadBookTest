package com.yuqf.readbooktest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondNavigationDrawerActivity extends AppCompatActivity {

    private ActionBarDrawerToggle drawerToggle;
    private final int[] MenuIconArray =
            {R.drawable.icon_de_nearby, R.drawable.icon_de_game, R.drawable.icon_de_ping,
                    R.drawable.icon_de_saoyisao, R.drawable.icon_de_shop, R.drawable.icon_de_yao,
                    R.drawable.icon_me_card, R.drawable.icon_me_collect, R.drawable.icon_me_money, R.drawable.icon_me_photo};
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_navigation_drawer);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_second);
//        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, actionBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//        };

//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] menuItems = getResources().getStringArray(R.array.menu_names_array);
        ListView listView = (ListView) findViewById(R.id.left_drawer);
        listView.setAdapter(new MyAdapter(this, menuItems, MenuIconArray));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private String[] menuItems;
        private int[] menuIcons;
        private Context context;

        public MyAdapter(Context context, String[] menuItems, int[] menuIcons) {
            super();
            inflater = LayoutInflater.from(context);
            this.menuItems = menuItems;
            this.menuIcons = menuIcons;
            this.context = context;
        }

        @Override
        public int getCount() {
            return menuItems.length;
        }

        @Override
        public Object getItem(int position) {
            if (position > menuItems.length - 1)
                return null;
            else
                return menuItems[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.drawer_list_item, parent, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.drawer_List_item_textview);
            textView.setText(menuItems[position]);

            Drawable icon = context.getResources().getDrawable(menuIcons[position]);
            icon.setBounds(0, 0, icon.getMinimumWidth() * 2 / 3, icon.getMinimumHeight() * 2 / 3);
            textView.setCompoundDrawables(icon, null, null, null);

            return convertView;
        }

    }
}
