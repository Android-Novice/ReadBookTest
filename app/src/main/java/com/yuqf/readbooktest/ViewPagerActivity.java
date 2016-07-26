package com.yuqf.readbooktest;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        List<View> viewList = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);
        View view1 = inflater.inflate(R.layout.activity_first_navigation_drawer, null);
        View view2 = inflater.inflate(R.layout.activity_second_navigation_drawer, null);
        View view3 = inflater.inflate(R.layout.activity_sliding_drawer, null);
        View view4 = inflater.inflate(R.layout.activity_sliding_pane_layout, null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(viewList);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager_first);
        viewPager.setAdapter(adapter);

    }

    class MyViewPagerAdapter extends PagerAdapter {
        private List<View> viewList;

        public MyViewPagerAdapter(List<View> viewList) {
            super();
            this.viewList = viewList;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    }
}
