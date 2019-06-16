package com.leslie.forxbb01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button1;
    Button button2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewShow);
        button1 = findViewById(R.id.buttonLeft);
        button2 = findViewById(R.id.buttonRight);
        imageView = findViewById(R.id.imageView);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText("Mua");
                textView.setText("小可爱");
                imageView.setImageDrawable(getDrawable(R.drawable.xbb));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setText("Pia");
                textView.setText("小骚货");
                imageView.setImageDrawable(getDrawable(R.drawable.xsh));
            }
        });
    }
}
