package com.example.rxjavapractices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class RxJavaActivity extends AppCompatActivity {

    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        startBtn = findViewById(R.id.btn_start_rx_java);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRxJava();
            }
        });
    }

    private void startRxJava() {
        Observer observer = new Observer<String>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(final String s) {
                startBtn.post(new Runnable() {
                    @Override
                    public void run() {
                        startBtn.setText(s);
                    }
                });
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                int count = 0;
                while (count <= 10) {
                    emitter.onNext(count);
                    SystemClock.sleep(1000);
                    count++;
                }
            }
        });

        observable
                .map(new Function<Integer, String>(){

                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "The number is " + integer;
                    }
                })
                .subscribe(observer);
    }
}