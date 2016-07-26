package com.yuqf.readbooktest;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

public class UIControlsActivity extends AppCompatActivity {

	private EditText editTextUser;
	private RadioGroup radioGroup;
	private RadioButton radioBtnMale;
	private RadioButton radioBtnFemale;
	private CheckBox checkboxSing;
	private CheckBox checkboxDance;
	private ToggleButton toggleBtnMarryStatus;
	private DatePicker datepickerBirthday;
	private Spinner spinnerFrom;
	private ImageView imageviewHead;
	private TextView textviewBirthday;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uicontrols);

		initControls();
	}

	private void initControls() {
		editTextUser = (EditText) findViewById(R.id.edittext_username);
		editTextUser.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub
				Log.w("TextView_UserName_beforeTextChanged", s.toString() + "_" + start + "_" + count + "_" + after);
				Toast.makeText(UIControlsActivity.this,
						"TextView_UserName_beforeTextChanged" + s.toString() + "_" + start + "_" + count + "_" + after,
						4000).show();
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				Log.w("TextView_UserName_onTextChanged", s.toString() + "_" + start + "_" + count);
				Toast.makeText(UIControlsActivity.this,
						"TextView_UserName_onTextChanged" + s.toString() + "_" + start + "_" + count, 4000).show();
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.w("TextView_UserName_afterTextChanged", s.toString());
				Toast.makeText(UIControlsActivity.this, "TextView_UserName_afterTextChanged" + s.toString(), 4000)
						.show();
			}
		});

		imageviewHead = (ImageView) findViewById(R.id.imageviewhead);
		imageviewHead.addOnLayoutChangeListener(new OnLayoutChangeListener() {

			@Override
			public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop,
					int oldRight, int oldBottom) {
				// TODO Auto-generated method stub
				Log.w("imageviewHead_onLayoutChange",
						(v.getId() == R.id.imageviewhead) ? "是同一个ImageView" : "不是同一个ImageView");
				Toast.makeText(UIControlsActivity.this,
						"imageviewHead_onLayoutChange"
								+ ((v.getId() == R.id.imageviewhead) ? "是同一个ImageView" : "不是同一个ImageView"),
						4000).show();
			}
		});

		radioGroup = (RadioGroup) findViewById(R.id.radiogroup_sex);
		radioBtnMale = (RadioButton) findViewById(R.id.radiobutton_man);
		final TextPaint tbMale = radioBtnMale.getPaint();
		radioBtnFemale = (RadioButton) findViewById(R.id.radiobutton_woman);
		final TextPaint tbFemale = radioBtnFemale.getPaint();
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.radiobutton_man:
					tbMale.setFakeBoldText(true);
					tbFemale.setFakeBoldText(false);
					Toast.makeText(UIControlsActivity.this, "性别是男", 4000).show();
					break;
				case R.id.radiobutton_woman:
					tbMale.setFakeBoldText(false);
					tbFemale.setFakeBoldText(true);
					Toast.makeText(UIControlsActivity.this, "性别是女", 4000).show();
					break;
				}
			}
		});

		checkboxDance = (CheckBox) findViewById(R.id.checkbox_dance);
		checkboxSing = (CheckBox) findViewById(R.id.checkbox_sing);

		CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (buttonView != null) {
					TextPaint tb = buttonView.getPaint();
					tb.setFakeBoldText(isChecked);
				}
			}
		};
		checkboxSing.setOnCheckedChangeListener(listener);
		checkboxDance.setOnCheckedChangeListener(listener);

		toggleBtnMarryStatus = (ToggleButton) findViewById(R.id.togglebutton_marrystatus);
		toggleBtnMarryStatus.setOnCheckedChangeListener(listener);

		textviewBirthday = (TextView) findViewById(R.id.textviewbirthday);
		datepickerBirthday = (DatePicker) findViewById(R.id.datepicker_birthday);
		datepickerBirthday.init(2008, 8, 8, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				// TODO Auto-generated method stub
				String birthday = year + "年" + monthOfYear + "月" + dayOfMonth + "日";
				textviewBirthday.setText("这个傻逼的生日是：" + birthday);
			}
		});

		final String[] destinationArr = new String[] { "香港", "澳门", "台湾", "深圳", "广州", "驻马店", "郑州", "北京", "天津" };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,
				destinationArr);
		adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
		spinnerFrom = (Spinner) findViewById(R.id.spinner_from);
		spinnerFrom.setAdapter(adapter);
		spinnerFrom.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(UIControlsActivity.this, "你点击的是第" + (position + 1) + "项, 地名：" + destinationArr[position],
						5000).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				Toast.makeText(UIControlsActivity.this, "没有选择任何项从Spinner", 5000).show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.uicontrols, menu);
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
}
