package com.yuqf.readbooktest;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainNewActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String Authority = "com.yuqf.contentproviderdemo.mycontentprovider";
    private static final String FIRST_TABLE = "book_info";

    private Button btnQuerry;
    private Button btnInsert;
    private Button btnUpdate;
    private Button btnDeleteItem;
    private Button btnDeleteAll;
    private EditText editTextName;
    private EditText editTextAuthor;
    private Spinner spinnerDeletingId;
    private Spinner spinnerUpdate;
    private TextView textViewShowBooks;

    private Uri uri;
    private static final String[] BOOK_FIRST_ARR = new String[]{"二际", "经理", "老板", "人力资源", "大胖妞", "小矮女人", "疯子", "信息中心", "大傻", "Windows"};
    private static final String[] BOOK_SECOND_ARR = new String[]{"打", "Kiss", "骂", "叫", "喊", "是", "Kill", " Is ", "杀", "鄙视"};
    private static final String[] BOOK_THIRD_ARR = new String[]{"疯子", "二逼", "牛逼", "天才", "精英", "禽兽", "笨蛋", "蠢人", "木蛋儿", "信球"};
    private static final String[] AUTHORARR = new String[]{"苍老师", "余巍际", "詹猩猩", "水花兄弟", "雷霆双少", "哈瞪眼", "霍华德", "爱神乐福", "维斯", "牛逼"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        btnQuerry = (Button) findViewById(R.id.btn_get_book_info);
        btnQuerry.setOnClickListener(this);
        btnDeleteAll = (Button) findViewById(R.id.btn_delete_all_books);
        btnDeleteAll.setOnClickListener(this);
        btnDeleteItem = (Button) findViewById(R.id.btn_delete_book_info);
        btnDeleteItem.setOnClickListener(this);
        btnUpdate = (Button) findViewById(R.id.btn_update_book_info);
        btnUpdate.setOnClickListener(this);
        btnInsert = (Button) findViewById(R.id.btn_insert_book_info);
        btnInsert.setOnClickListener(this);
        editTextAuthor = (EditText) findViewById(R.id.edit_text_author);
        editTextName = (EditText) findViewById(R.id.edit_text_name);
        spinnerDeletingId = (Spinner) findViewById(R.id.spinner_delete);
        textViewShowBooks = (TextView) findViewById(R.id.text_view_show_books);
        spinnerUpdate = (Spinner) findViewById(R.id.spinner_update);

        spinnerUpdate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int curId = (int) spinnerUpdate.getSelectedItem();
                Uri curUri = ContentUris.withAppendedId(uri, curId);
                Cursor cursor = getContentResolver().query(curUri, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        editTextName.setText(name);
                        editTextAuthor.setText(author);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                editTextAuthor.setText("");
                editTextName.setText("");
            }
        });

        uri = Uri.parse("content://" + Authority + "/" + FIRST_TABLE);
    }

    @Override
    public void onClick(View v) {
        ContentResolver resolver = getContentResolver();
        switch (v.getId()) {
            case R.id.btn_get_book_info:
                String oldStr = "";
                List<Integer> idList = new ArrayList<Integer>();
                Cursor cursor = resolver.query(uri, null, null, null, null);
                int total = cursor != null ? cursor.getCount() : 0;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(cursor.getColumnIndex("id"));
                        idList.add(id);
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pageCount = cursor.getInt(cursor.getColumnIndex("pages"));
                        oldStr += "\n" + id + "_" + name + "_" + author + "_" + pageCount;
                    }
                    Log.d("Yuqf", "5");
                    textViewShowBooks.setText(oldStr);
                }
                ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(MainNewActivity.this, R.layout.support_simple_spinner_dropdown_item, idList);
                adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                spinnerUpdate.setAdapter(null);
                spinnerUpdate.setAdapter(adapter);
                spinnerDeletingId.setAdapter(null);
                spinnerDeletingId.setAdapter(adapter);
                Toast.makeText(MainNewActivity.this, "获取成功，总数是：" + total, Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_insert_book_info:
                Random random = new Random();
                int first = random.nextInt(10);
                int second = (int) (Math.random() * 10);
                int third = random.nextInt(10);
                int authorIndex = (int) (Math.random() * 10);
                Log.d("Yuqf", first + "_" + second + "_" + third + "_" + authorIndex);
                String bookName = BOOK_FIRST_ARR[first] + BOOK_SECOND_ARR[second] + BOOK_THIRD_ARR[third];
                ContentValues cvInsert = new ContentValues();
                cvInsert.put("name", bookName);
                cvInsert.put("author", AUTHORARR[authorIndex]);
                cvInsert.put("pages", new Random().nextInt(1000));

                resolver.insert(uri, cvInsert);
                StringBuilder sb = new StringBuilder("插入成功，新书的名字是：");
                sb.append(bookName);
                sb.append("\n");
                sb.append("当前作者：");
                sb.append(AUTHORARR[authorIndex]);
                Toast.makeText(MainNewActivity.this, sb.toString(), Toast.LENGTH_LONG).show();

                btnQuerry.performClick();
                break;
            case R.id.btn_update_book_info:
                String newName = editTextName.getText().toString();
                String newAuthor = editTextAuthor.getText().toString();

                int curId = (int) spinnerUpdate.getSelectedItem();
                Uri curUri = ContentUris.withAppendedId(uri, curId);
                Cursor cursor1 = resolver.query(curUri, null, null, null, null);
                cursor1.moveToNext();
                String oldName = cursor1.getString(cursor1.getColumnIndex("name"));
                String oldAuthor = cursor1.getString(cursor1.getColumnIndex("author"));
                if ((!TextUtils.isEmpty(newName) && !newName.equals(oldName)) || (TextUtils.isEmpty(newAuthor) && !newAuthor.equals(oldAuthor))) {
                    ContentValues contentValues = new ContentValues();
                    if (!TextUtils.isEmpty(newName) && !newName.equals(oldName))
                        contentValues.put("name", newName);
                    if (!TextUtils.isEmpty(newAuthor) && !newAuthor.equals(oldAuthor))
                        contentValues.put("author", newAuthor);
                    if (resolver.update(curUri, contentValues, null, null) > 0) {
                        StringBuilder sb1 = new StringBuilder("修改成功，书籍《");
                        sb1.append(oldName + "》已经更名为《");
                        sb1.append(newName);
                        sb1.append("》\n");
                        sb1.append("作者是 " + newAuthor);
                        Toast.makeText(MainNewActivity.this, sb1.toString(), Toast.LENGTH_LONG).show();

                        btnQuerry.performClick();
                    }
                }
                break;
            case R.id.btn_delete_book_info:
                int deletingId = (int) spinnerDeletingId.getSelectedItem();
                Uri deletingUri = ContentUris.withAppendedId(uri, deletingId);
                Cursor cursor2 = resolver.query(deletingUri, null, null, null, null);
                cursor2.moveToNext();
                String oldName1 = cursor2.getString(cursor2.getColumnIndex("name"));
                if (resolver.delete(deletingUri, null, null) > 0) {
                    Toast.makeText(MainNewActivity.this, "《" + oldName1 + "》已经删除！", Toast.LENGTH_LONG).show();
                    btnQuerry.performClick();
                }
                break;
            case R.id.btn_delete_all_books:
                if (resolver.delete(uri, null, null) > 0) {
                    Toast.makeText(MainNewActivity.this, "已经全部删除成功！", Toast.LENGTH_LONG).show();
                    btnQuerry.performClick();
                }
                break;
        }
    }
}
