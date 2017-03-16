package com.example.kimsoohyeong.week3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends AppCompatActivity {
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    void init() {
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
    }

    public void onMyClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.b1:
                intent = new Intent(Main.this, Score.class);
                startActivity(intent);
                break;
            case R.id.b2:
                intent = new Intent(Main.this, Reservation.class);
                startActivity(intent);
                break;
        }
    }
}
