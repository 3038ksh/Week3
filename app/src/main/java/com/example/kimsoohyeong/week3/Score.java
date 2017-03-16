package com.example.kimsoohyeong.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1, b2;
    TextView t1, t2;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        setTitle("학점 계산기");

        init();
    }

    void init() {
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        e3 = (EditText)findViewById(R.id.e3);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        i1 = (ImageView)findViewById(R.id.i1);

    }

    public void onMyClick(View v) {
        i1.setVisibility(View.GONE);
        switch (v.getId()) {
            case R.id.b1:
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();
                String str3 = e3.getText().toString();
                int sco1 = str1.equals("") ? 0 : Integer.parseInt(str1);
                int sco2 = str2.equals("") ? 0 : Integer.parseInt(str2);
                int sco3 = str3.equals("") ? 0 : Integer.parseInt(str3);

                int avg = (sco1 + sco2 + sco3) / 3;

                t1.setText(Integer.toString(sco1 + sco2 + sco3) + "점");
                t2.setText(Integer.toString(avg) + "점");

                if (avg >= 90) i1.setImageResource(R.drawable.a);
                else if (avg >= 80) i1.setImageResource(R.drawable.b);
                else if (avg >= 70) i1.setImageResource(R.drawable.c);
                else if (avg >= 60) i1.setImageResource(R.drawable.d);
                else i1.setImageResource(R.drawable.f);

                i1.setVisibility(View.VISIBLE);
                break;
            case R.id.b2:
                Toast.makeText(getApplicationContext(),
                        "초기화 되었습니다.",
                        Toast.LENGTH_SHORT).show();
                t1.setText("0점");
                t2.setText("0점");
                e1.setText("");
                e2.setText("");
                e3.setText("");
                i1.setVisibility(View.GONE);
                break;
        }
    }
}
