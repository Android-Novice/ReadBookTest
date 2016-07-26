package com.yuqf.readbooktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SlidingDrawer;

public class SlidingDrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_drawer);

        final ImageButton imageButton = (ImageButton) findViewById(R.id.imagebutton);
        final View defaultBkgView = (View) findViewById(R.id.default_bkg);

        SlidingDrawer slidingDrawer = (SlidingDrawer) findViewById(R.id.sliding_drawer);
        slidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                imageButton.setImageResource(R.drawable.handle_up);
                defaultBkgView.setVisibility(View.VISIBLE);
            }
        });

        slidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                imageButton.setImageResource(R.drawable.handle_down);
                defaultBkgView.setVisibility(View.INVISIBLE);
            }
        });
    }
}
