package com.example.kimsoohyeong.week3;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Reservation extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = Reservation.class.getSimpleName();

    Switch s1;
    Chronometer c1;
    EditText e1, e2, e3;
    DatePicker dp1;
    TimePicker tp1;
    Button b1, b2;
    LinearLayout ll1;
    FrameLayout fl1;
    GridLayout gl1, gl2;
    TextView t1, t2, t3, t4, t5, t6;
    int year, month, day;
    int hour, min;
    int cnt1, cnt2, cnt3;
    final AtomicInteger step = new AtomicInteger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        init();
    }

    void init() {
        step.set(0);
        s1 = (Switch)findViewById(R.id.s1);
        c1 = (Chronometer)findViewById(R.id.c1);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        t3 = (TextView)findViewById(R.id.t3);
        t4 = (TextView)findViewById(R.id.t4);
        t5 = (TextView)findViewById(R.id.t5);
        t6 = (TextView)findViewById(R.id.t6);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        e3 = (EditText)findViewById(R.id.e3);
        dp1 = (DatePicker)findViewById(R.id.dp1);
        tp1 = (TimePicker)findViewById(R.id.tp1);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        ll1 = (LinearLayout)findViewById(R.id.ll1);
        fl1 = (FrameLayout)findViewById(R.id.fl1);
        gl1 = (GridLayout)findViewById(R.id.gl1);
        gl2 = (GridLayout)findViewById(R.id.gl2);

        s1.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "Called onMyClick");

        switch (v.getId()) {
            case R.id.s1:
                if (s1.isChecked()) {
                    c1.setBase(SystemClock.elapsedRealtime());
                    t1.setVisibility(View.VISIBLE);
                    c1.setVisibility(View.VISIBLE);
                    c1.start();
                } else {
                    step.set(0);
                }
                break;
            case R.id.b1:
                step.set(step.get() - 1);
                break;
            case R.id.b2:
                step.set(step.get() + 1);
                break;
        }
        switch (step.get()) {
            case 0:
                if (s1.isChecked()) {
                    tp1.setVisibility(View.GONE);
                    fl1.setVisibility(View.VISIBLE);
                    dp1.setVisibility(View.VISIBLE);
                    ll1.setVisibility(View.VISIBLE);
                    b2.setEnabled(true);
                    b1.setEnabled(false);
                } else {
                    c1.stop();
                    year = month = day = 0;
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    t1.setVisibility(View.INVISIBLE);
                    c1.setVisibility(View.INVISIBLE);
                    tp1.setVisibility(View.GONE);
                    dp1.setVisibility(View.GONE);
                    ll1.setVisibility(View.GONE);
                    fl1.setVisibility(View.GONE);
                    gl1.setVisibility(View.GONE);
                }
                break;
            case 1:
                year = dp1.getYear();
                month = dp1.getMonth();
                day = dp1.getDayOfMonth();
                b1.setEnabled(true);
                dp1.setVisibility(View.GONE);
                gl1.setVisibility(View.GONE);
                tp1.setVisibility(View.VISIBLE);
                break;
            case 2:
                hour = tp1.getHour();
                min = tp1.getMinute();
                b2.setEnabled(true);
                tp1.setVisibility(View.GONE);
                gl1.setVisibility(View.VISIBLE);
                gl2.setVisibility(View.GONE);
                break;
            case 3:
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();
                String str3 = e3.getText().toString();
                cnt1 = str1.equals("") ? 0 : Integer.parseInt(str1);
                cnt2 = str1.equals("") ? 0 : Integer.parseInt(str2);
                cnt3 = str1.equals("") ? 0 : Integer.parseInt(str3);
                t2.setText(year + "년 " + month + "월 " + day + "일");
                t3.setText(hour + "시 " + min + "분");
                t4.setText(cnt1 + "명");
                t5.setText(cnt2 + "명");
                t6.setText(cnt3 + "명");
                gl1.setVisibility(View.GONE);
                gl2.setVisibility(View.VISIBLE);
                b2.setEnabled(false);
        }
    }
}
