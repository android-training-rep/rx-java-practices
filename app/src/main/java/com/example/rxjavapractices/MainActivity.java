package com.example.rxjavapractices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button toRxJavaBtn = findViewById(R.id.btn_to_rx_java);
        toRxJavaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRxJava();
            }
        });
    }

    private void toRxJava() {
        Intent intent = new Intent(this, RxJavaActivity.class);
        startActivity(intent);
    }
}