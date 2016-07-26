package com.yuqf.readbooktest;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button btnDialog1 = (Button) findViewById(R.id.btnnormaldialog1);
        btnDialog1.setOnClickListener(new ButtonClickListener());

        Button btnDialog2 = (Button) findViewById(R.id.btnnormaldialog2);
        btnDialog2.setOnClickListener(new ButtonClickListener());

        Button btnDialog3 = (Button) findViewById(R.id.btnnormaldialog3);
        btnDialog3.setOnClickListener(new ButtonClickListener());

        Button btnDialog4 = (Button) findViewById(R.id.btnnormaldialog4);
        btnDialog4.setOnClickListener(new ButtonClickListener());

        Button btnDialog5 = (Button) findViewById(R.id.btnnormaldialog5);
        btnDialog5.setOnClickListener(new ButtonClickListener());

        Button btnDialog6 = (Button) findViewById(R.id.btndatedialog);
        btnDialog6.setOnClickListener(new ButtonClickListener());

        Button btnDialog7 = (Button) findViewById(R.id.btntimedialog);
        btnDialog7.setOnClickListener(new ButtonClickListener());

        Button btnDialog8 = (Button) findViewById(R.id.btnprogressdialog);
        btnDialog8.setOnClickListener(new ButtonClickListener());

        Button btnDialog9 = (Button) findViewById(R.id.btncustomdialog);
        btnDialog9.setOnClickListener(new ButtonClickListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dialog, menu);
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

    private void showNormalDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.canglaoshi_30);
        builder.setMessage("ȷ��Ҫ��̼�����Ϸ��Ҫ�����Ǯ�����Ե�Ӵ��");
        builder.setTitle("ѯ��");
        builder.setPositiveButton("ȷ��", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                Toast.makeText(DialogActivity.this, "���ȷ��Ҫ����̼�����Ϸ���ֵ��ǣ�Ƥ���ź�", 3000).show();
            }
        });

        builder.setNegativeButton("ȡ��", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                Toast.makeText(DialogActivity.this, "������ˣ��ֵ��ǣ����ŷŹ���", 3000).show();
            }
        });

        builder.setNeutralButton("��ʱûʱ��", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                Toast.makeText(DialogActivity.this, "�ֵ��ǣ�������ĵ�һ�£�������쵰�´ι�����������ʰ����", 3000).show();
            }
        });

        AlertDialog dialog = builder.create();
        updateSysDialog(dialog);
        dialog.show();
    }

    private void updateSysDialog(AlertDialog dialog) {
        //�ָ���
        int dividerId = getResources().getIdentifier("titleDivider", "id", getPackageName());
        if(dividerId>0) {
            View dividerView = dialog.findViewById(dividerId);
            dividerView.setBackgroundColor(Color.GREEN);
        }
        //����
        int contentId = getResources().getIdentifier("message", "id", getPackageName());
        if(contentId>0) {
            TextView contentTV = (TextView) dialog.findViewById(contentId);
            contentTV.setTextColor(Color.GREEN);
        }
        //������ť
        int btn1Id = getResources().getIdentifier("button1", "id", getPackageName());
        if(btn1Id>0) {
            Button button1 = (Button) dialog.findViewById(btn1Id);
            button1.setTextColor(Color.GREEN);
        }

        int btn3Id = getResources().getIdentifier("button3", "id", getPackageName());
        if(btn3Id>0) {
            Button button3 = (Button) dialog.findViewById(btn3Id);
            button3.setTextColor(Color.GREEN);
        }

        int btn2Id = getResources().getIdentifier("button2", "id", getPackageName());
        if(btn2Id>0) {
            Button button2 = (Button) dialog.findViewById(btn2Id);
            button2.setTextColor(Color.GREEN);
        }
    }

    private void showNormalDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.canglaoshi_30);
        builder.setMessage("ȷ��Ҫ��̼�����Ϸ��Ҫ�����Ǯ�����Ե�Ӵ��");
        builder.setTitle("ѯ��");

        OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                switch (which) {
                    case Dialog.BUTTON_POSITIVE:
                        Toast.makeText(DialogActivity.this, "���ȷ��Ҫ����̼�����Ϸ���ֵ��ǣ�Ƥ���ź�", 3000).show();
                        break;
                    case Dialog.BUTTON_NEUTRAL:
                        Toast.makeText(DialogActivity.this, "�ֵ��ǣ�������ĵ�һ�£�������쵰�´ι�����������ʰ����", 3000).show();
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        Toast.makeText(DialogActivity.this, "������ˣ��ֵ��ǣ����ŷŹ���", 3000).show();
                        break;
                }
            }
        };

        builder.setPositiveButton("ȷ��", listener);
        builder.setNegativeButton("ȡ��", listener);
        builder.setNeutralButton("��ʱûʱ��", listener);

        builder.create().show();
    }

    final String[] dialogStringArr = new String[]{"��", "Ů", "����", "��", "����", "����", "�߾�"};
    final boolean[] checkStatusArr = new boolean[]{false, false, false, false, false, false, true};

    final HashMap<String, Boolean> checkStatusMap = new HashMap<String, Boolean>();

    private void showListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ѡ��ɱ����Ա�:");
        builder.setIcon(R.drawable.canglaoshi_30);
        builder.setItems(dialogStringArr, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(DialogActivity.this, "�������ǵ�" + (which + 1) + "��Ա�" + dialogStringArr[which], 3000)
                        .show();
            }
        });
        // �����ټ������ť����Ϊ�����������ʱ�򣬾��Ѿ�ѡ�������� �������Ǽ��������ť�Ͳ����ټ������Toast�����������⣩
        // builder.setPositiveButton("ȷ��", new OnClickListener() {
        // @Override
        // public void onClick(DialogInterface dialog, int which) {
        // // TODO Auto-generated method stub
        // dialog.dismiss();
        // Toast.makeText(DialogActivity.this, "�������ǵ�" + (which + 1) +
        // "�ɱ����Ա���" + dialogStringArr[which], 3000)
        // .show();
        // }
        // });
        builder.create().show();
    }

    private void showRadioDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ѡ��ɱ����Ա�:");
        builder.setIcon(R.drawable.canglaoshi_30);
        builder.setSingleChoiceItems(dialogStringArr, 2, new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                // Toast.makeText(DialogActivity.this, "�������ǵ�" + (which + 1) +
                // "��Ա�" + dialogStringArr[which], 3000)
                // .show();
                Toast.makeText(DialogActivity.this, "�������ǵ�" + (which + 1) + "�ɱ����Ա���" + dialogStringArr[which], 3000)
                        .show();
            }
        });
        builder.setPositiveButton("ȷ��", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                // ���ܼ��������Ϊ��ѡDialog�����which��-1,
                // Toast.makeText(DialogActivity.this, "�������ǵ�" + (which + 1) +
                // "�ɱ����Ա���" + dialogStringArr[which], 3000)
                // .show();
            }
        });
        builder.create().show();
    }

    private void showCheckBoxDialog() {
        checkStatusMap.clear();
        for (int i = 0; i < dialogStringArr.length; i++) {
            checkStatusMap.put(dialogStringArr[i], checkStatusArr[i]);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ѡ��ɱ����Ա�:");
        builder.setIcon(R.drawable.canglaoshi_30);
        builder.setMultiChoiceItems(dialogStringArr, checkStatusArr, new OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // TODO Auto-generated method stub
                // if (checkStatusMap.containsKey(dialogStringArr[which])) {
                // checkStatusMap.remove(dialogStringArr[which]);
                // }
                checkStatusMap.put(dialogStringArr[which], isChecked);
                String firstStr = isChecked ? "�㹴ѡ��" : "��ȡ����ѡ��";
                Toast.makeText(DialogActivity.this,
                        firstStr + "��" + (which + 1) + "�" + firstStr + "���Ա���" + dialogStringArr[which], 3000).show();
            }
        });

        builder.setPositiveButton("ȷ��", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                // ����������Toast����Ϊ�����which�Ѿ���-1��û��Ч���ˡ�
                // Toast.makeText(DialogActivity.this, "�������ǵ�" + (which + 1) +
                // "�ɱ����Ա���" + dialogStringArr[which], 3000)
                // .show();
                String sexStr = "";
                for (int i = 0; i < checkStatusMap.size(); i++) {
                    String key = dialogStringArr[i];
                    if (checkStatusMap.containsKey(key)) {
                        boolean checked = checkStatusMap.get(key);
                        if (checked)
                            sexStr += "_" + key;
                    }
                }
                Toast.makeText(DialogActivity.this, "ɱ����Ա���" + sexStr, 3000).show();
            }
        });
        builder.create().show();

    }

    private void showDatePickerDialog() {
        OnDateSetListener listener = new OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                Toast.makeText(DialogActivity.this, "ѡ��������ǣ�" + year + "/" + monthOfYear + "/" + dayOfMonth, 1000)
                        .show();
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        DatePickerDialog dialog = new DatePickerDialog(DialogActivity.this, listener, year, month, day);
        dialog.setIcon(R.drawable.canglaoshi_30);
        DatePicker picker = dialog.getDatePicker();
        picker.setCalendarViewShown(false);
        dialog.show();
    }

    private void showTimePickerDialog() {
        OnTimeSetListener listener = new OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // TODO Auto-generated method stub
                Toast.makeText(DialogActivity.this, "ѡ���ʱ���ǣ�" + hourOfDay + "��" + minute, 1000).show();
            }
        };
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog dialog = new TimePickerDialog(DialogActivity.this, listener, hour, minute, true);
        dialog.show();
    }

    private void showProgressDialog() {
        OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                switch (which) {
                    case Dialog.BUTTON_POSITIVE:
                        Toast.makeText(DialogActivity.this, "���ȡ������ȷ��Ҫ����̼�����Ϸ���ֵ��ǣ�Ƥ���ź�", 3000).show();
                        break;
                    case Dialog.BUTTON_NEUTRAL:
                        Toast.makeText(DialogActivity.this, "���ȡ����ֵ��ǣ�������ĵ�һ�£�������쵰�´ι�����������ʰ����", 3000).show();
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        Toast.makeText(DialogActivity.this, "���ȡ���������ˣ��ֵ��ǣ����ŷŹ���", 3000).show();
                        break;
                }
            }
        };

        ProgressDialog dialog = new ProgressDialog(DialogActivity.this);
        dialog.setButton(Dialog.BUTTON_NEGATIVE, "ȡ��", listener);
        dialog.setButton(Dialog.BUTTON_NEUTRAL, "�´ΰ�", listener);
        dialog.setButton(Dialog.BUTTON_POSITIVE, "����", listener);

        dialog.setIcon(R.drawable.canglaoshi_30);
        dialog.setMessage("�ҽ���ʮ�ˣ���һ���Ҿ���ʮ��...");
//		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setProgressStyle(ProgressDialog.BUTTON_NEGATIVE);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("�ȵ���");
//		dialog.setCancelable(true);
        dialog.show();
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.canglaoshi_30);
        builder.setTitle("��¼");

        LayoutInflater inflater = LayoutInflater.from(DialogActivity.this);
        final View view = inflater.inflate(R.layout.customdialogview, null);
        builder.setView(view);

        OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                EditText etUser = (EditText) view.findViewById(R.id.edittext_username);
                String userStr = etUser.getText().toString();
                EditText etPsw = (EditText) view.findViewById(R.id.edittext_password);
                String pswStr = etPsw.getText().toString();
                String connStr = "�û�����" + userStr + "�����룺" + pswStr;
                dialog.dismiss();
                switch (which) {
                    case Dialog.BUTTON_POSITIVE:
                        Toast.makeText(DialogActivity.this, "���ȷ��Ҫ����̼�����Ϸ���ֵ��ǣ�Ƥ���ź�" + connStr, 3000).show();
                        break;
                    case Dialog.BUTTON_NEUTRAL:
                        Toast.makeText(DialogActivity.this, "�ֵ��ǣ�������ĵ�һ�£�������쵰�´ι�����������ʰ����" + connStr, 3000).show();
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        Toast.makeText(DialogActivity.this, "������ˣ��ֵ��ǣ����ŷŹ���" + connStr, 3000).show();
                        break;
                }
            }
        };

        builder.setPositiveButton("ȷ��", listener);
        builder.setNegativeButton("ȡ��", listener);
        // builder.setNeutralButton("��ʱûʱ��", listener);

        builder.create().show();
    }

    class ButtonClickListener implements android.view.View.OnClickListener {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.btnnormaldialog1:
                    showNormalDialog1();
                    break;
                case R.id.btnnormaldialog2:
                    showNormalDialog2();
                    break;
                case R.id.btnnormaldialog3:
                    showListDialog();
                    break;
                case R.id.btnnormaldialog4:
                    showRadioDialog();
                    break;
                case R.id.btnnormaldialog5:
                    showCheckBoxDialog();
                    break;
                case R.id.btndatedialog:
                    showDatePickerDialog();
                    break;
                case R.id.btntimedialog:
                    showTimePickerDialog();
                    break;
                case R.id.btnprogressdialog:
                    showProgressDialog();
                    break;
                case R.id.btncustomdialog:
                    showCustomDialog();
                    break;
            }
        }
    }
}
