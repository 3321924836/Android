package com.leslie.networkcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //private WebView webView;
    private EditText et_path;
    private Button btn_show;
    private ImageView image;

    //UI thread's message handler
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 1) {
                Bitmap bitmap = (Bitmap) msg.obj;
                image.setImageBitmap(bitmap);
            } else if (msg.what == 0) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //webView = findViewById(R.id.webView);
        //webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("http://www.zjnu.edu.cn");

        et_path = findViewById(R.id.editText_url);
        btn_show = findViewById(R.id.button_show);
        image = findViewById(R.id.imageView);
        btn_show.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_show:
                final String path = et_path.getText().toString().trim();
                if (path.isEmpty()) {
                    Toast.makeText(this, "URL为空", Toast.LENGTH_LONG).show();
                } else { //with given url,send request to the server in a new thread
                    new Thread() {
                        private HttpURLConnection connection;
                        private Bitmap bitmap;

                        public void run() {
                            try {
                                //1. create URL object
                                //URL url = new URL(path);
                                URL url = new URL("https://profile.csdnimg.cn/8/E/0/3_qianxiangsen");
                                //2. send HTTP request
                                connection = (HttpURLConnection) url.openConnection();
                                //3. set the request manner
                                connection.setRequestMethod("GET");
                                connection.setConnectTimeout(5000);
                                //4. check the request code
                                int code = connection.getResponseCode();
                                if (code == 200) {//succeed in response
                                    //get input stream in  bytes for downloading
                                    InputStream inputStream = connection.getInputStream();
                                    //convert bytes into bitmap
                                    bitmap = BitmapFactory.decodeStream(inputStream);
                                    //?????
                                    Log.i("Bitmap", "Downloaded and decoded");
                                    //send a good message
                                    Message msg = new Message();
                                    msg.what = 1;
                                    msg.obj = bitmap;
                                    //send message?
                                    handler.sendMessage(msg);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.i("Bitmap", "Failed to download and decoded");
                                //send a bad message
                                Message msg = new Message();
                                msg.what = 0;
                                //send this message
                                handler.sendMessage(msg);
                            }
                            connection.disconnect();
                        }
                    }.start();
                }
                break;
        }
    }
}
