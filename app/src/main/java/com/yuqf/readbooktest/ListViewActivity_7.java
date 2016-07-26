package com.yuqf.readbooktest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListViewActivity_7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_activity_7);
        final List<Message> messageList = initMessage();
        final MyAdapter7 adapter7 = new MyAdapter7(ListViewActivity_7.this, R.layout.message_textviewitem, messageList);
        final ListView listview = (ListView) findViewById(R.id.listview6);
        listview.setAdapter(adapter7);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (view != null) {
                    listview.setSelection(position);
                    listview.setItemChecked(position, true);
                    view.setSelected(true);

//                    listview.getSelectedView().setSelected(true);
                }
            }
        });

        Button btnSend = (Button) findViewById(R.id.btnsendmsg);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText messageTV = (EditText) findViewById(R.id.sendingmsg_textview);
                String message = messageTV.getText().toString();
                if (message != null && !message.isEmpty()) {
                    int randNum = new Random(100).nextInt();
                    Message msg = new Message(message, randNum % 2 == 0 ? true : false);
                    messageList.add(msg);
                    adapter7.notifyDataSetChanged();
                    listview.setSelection(messageList.size());
                    messageTV.setText("");
                }
            }
        });
    }

    private List<Message> initMessage() {
        List<Message> messageList = new ArrayList<>();
        Message message1 = new Message("qqqqqqqq", true);
        Message message2 = new Message("wwwwwwwww", false);
        Message message3 = new Message("rrdssssss", true);
        Message message4 = new Message("fffffffff", true);
        Message message5 = new Message("qqqxxxccccvvvxxx", false);
        messageList.add(message1);
        messageList.add(message2);
        messageList.add(message3);
        messageList.add(message4);
        messageList.add(message5);
        return messageList;
    }

    class MyAdapter7 extends ArrayAdapter<Message> {
        private int textviewResId;
        private LayoutInflater inflater;

        public MyAdapter7(Context context, int textviewResId, List<Message> messageList) {
            super(context, textviewResId, messageList);
            this.textviewResId = textviewResId;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MessageHolder holder = new MessageHolder();
            if (convertView == null) {
                convertView = inflater.inflate(textviewResId, parent, false);
                holder.leftTextView = (TextView) convertView.findViewById(R.id.msg_lefttextview);
                holder.rightTextView = (TextView) convertView.findViewById(R.id.msg_righttextview);

                convertView.setTag(holder);
            } else {
                holder = (MessageHolder) convertView.getTag();
            }

            Message message = getItem(position);
            if (message.isSended()) {
                holder.rightTextView.setVisibility(View.GONE);
                holder.leftTextView.setVisibility(View.VISIBLE);
                holder.leftTextView.setText(message.content);
            } else {
                holder.leftTextView.setVisibility(View.GONE);
                holder.rightTextView.setVisibility(View.VISIBLE);
                holder.rightTextView.setText(message.content);
            }
            return convertView;
        }

        class MessageHolder {
            private TextView leftTextView;
            private TextView rightTextView;
        }
    }

    class Message {
        private String content;
        private boolean sended;

        public Message(String content, boolean sended) {
            this.content = content;
            this.sended = sended;
        }

        public String getContent() {
            return content;
        }

        public boolean isSended() {
            return sended;
        }
    }
}
