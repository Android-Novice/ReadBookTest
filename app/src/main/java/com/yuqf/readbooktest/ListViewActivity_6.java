package com.yuqf.readbooktest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuqf.readbooktest.CommonMethods.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ListViewActivity_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_activity_6);

        List<War3Hero> war3Heros = new ArrayList<>();
        List<HashMap<String, Object>> items = CommonUtils.getData();
        for (HashMap<String, Object> map : items) {
            War3Hero hero = new War3Hero(map);
            war3Heros.add(hero);
        }
        ListView listView = (ListView) findViewById(R.id.listview5);
        MyAdapter6 adapter = new MyAdapter6(ListViewActivity_6.this, R.layout.textviewitem2, war3Heros);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (view != null) {
                    TextView textViewName = (TextView) view.findViewById(R.id.textview_lv211);
                    TextView textViewInfo = (TextView) view.findViewById(R.id.textview_lv212);
                    String name = textViewName.getText().toString();
                    String info = textViewInfo.getText().toString();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(name);
                    stringBuffer.append("\n" + info);
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListViewActivity_6.this);
                    builder.setIcon(R.drawable.canglaoshi_20);
                    builder.setMessage(stringBuffer);
                    builder.setTitle("你点击的是第" + (position + 1) + "项");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }
            }
        });
    }

    class MyAdapter6 extends ArrayAdapter<War3Hero> {
        private LayoutInflater inflater;
        private int textviewResId;

        public MyAdapter6(Context context, int viewItemId, List<War3Hero> heros) {
            super(context, viewItemId, heros);
            inflater = LayoutInflater.from(getContext());
            textviewResId = viewItemId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            HeroUIHolder holder = new HeroUIHolder();
            if (convertView == null) {
                convertView = inflater.inflate(textviewResId, parent, false);
                holder.imageView = (ImageView) convertView.findViewById(R.id.imageview2);
                holder.textViewName = (TextView) convertView.findViewById(R.id.textview_lv211);
                holder.textviewInfo = (TextView) convertView.findViewById(R.id.textview_lv212);
                holder.button = (Button) convertView.findViewById(R.id.btnmore);
                convertView.setTag(holder);
            } else {
                holder = (HeroUIHolder) convertView.getTag();
            }
            final War3Hero hero = getItem(position);
            holder.textViewName.setText(hero.getName());
            holder.textviewInfo.setText(hero.getDescription());
            holder.imageView.setImageResource(hero.getHeadPortraitId());
            String text = holder.button.getText().toString();
            holder.button.setText(text + position);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), hero.getName() + "_" + hero.getDescription(), 3000).show();
                }
            });
            return convertView;
        }

        class HeroUIHolder {
            public ImageView imageView;
            public TextView textViewName;
            public TextView textviewInfo;
            public Button button;
        }
    }

    class War3Hero {
        private String name;
        private int headPortraitId;
        private String description;

        public War3Hero(HashMap<String, Object> map) {
            name = (String) map.get("title");
            description = (String) map.get("info");
            headPortraitId = (int) map.get("img");
        }

        public String getName() {
            return name;
        }

        public int getHeadPortraitId() {
            return headPortraitId;
        }

        public String getDescription() {
            return description;
        }

    }
}
