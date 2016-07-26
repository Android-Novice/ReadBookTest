package com.yuqf.readbooktest;

import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SlidingPaneLayoutActivity extends AppCompatActivity {

    private final String Tag = "SlidingPaneLayout_Debug";
    private SlidingPaneLayout slidingPaneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_pane_layout);

        final TextView textViewLeft = (TextView) findViewById(R.id.textview_sliding_left);
        final TextView textviewRight = (TextView) findViewById(R.id.textview_sliding_right);
        textViewLeft.setAlpha(0f);
        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        slidingPaneLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.d(Tag, String.valueOf(slideOffset));
                textViewLeft.setAlpha(slideOffset);
                textviewRight.setAlpha(1 - slideOffset);
            }

            @Override
            public void onPanelOpened(View panel) {
                Log.d(Tag, "Opened");
            }

            @Override
            public void onPanelClosed(View panel) {
                Log.d(Tag, "Closed");
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (slidingPaneLayout.isOpen())
            slidingPaneLayout.closePane();
        else
            finish();
    }
}
