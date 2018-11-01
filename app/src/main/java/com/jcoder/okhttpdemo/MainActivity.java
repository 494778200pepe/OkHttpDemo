package com.jcoder.okhttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d("Thread.name = " + Thread.currentThread().getName());
        getAsync();
    }

    private void getSync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder().url("http://www.baidu.com").build();
                try {
                    Response response = client.newCall(request).execute();
                    Logger.d("Thread.name = " + Thread.currentThread().getName());
                    Logger.d("code = " + response.code());
                    Logger.d("message = " + response.message());
                    Logger.d("body = " + response.body());
                    Logger.d("headers = " + response.headers());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void getAsync() {
        final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logger.d("getAsync request failed ");
                Logger.d("Thread.name = " + Thread.currentThread().getName());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.d("getAsync request success ");
                Logger.d("Thread.name = " + Thread.currentThread().getName());
                Logger.d("code = " + response.code());
                Logger.d("message = " + response.message());
                Logger.d("body = " + response.body());
                Logger.d("headers = " + response.headers());
            }
        });

    }
}
