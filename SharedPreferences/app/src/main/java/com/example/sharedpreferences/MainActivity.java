package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textName, textTel;
    private Button btnStore, btnRead, btnFin, btnFout;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private FileInputStream fis;
    private FileOutputStream fos;
    private final static String filename = "user.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName = findViewById(R.id.editText);
        textTel = findViewById(R.id.editText2);
        btnStore = findViewById(R.id.button_store);
        btnRead = findViewById(R.id.button_read);
        btnFin = findViewById(R.id.button_filein);
        btnFout = findViewById(R.id.button_fileout);
        btnStore.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnFin.setOnClickListener(this);
        btnFout.setOnClickListener(this);
        sp = this.getSharedPreferences(filename, MODE_PRIVATE);
        editor = sp.edit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_store:
                String v1 = textName.getText().toString().trim();
                String v2 = textTel.getText().toString().trim();
                if (v1 == "" || v2 == "") break;
                editor.putString("name", v1);
                editor.putString("phone", v2);
                editor.commit();
                Toast.makeText(this, "Writing SP, finished", Toast.LENGTH_LONG).show();
                break;
            case R.id.button_read:
                String s1 = sp.getString("name", "___");
                String s2 = sp.getString("phone", "NA");
                textName.setText(s1);
                textTel.setText(s2);
                Toast.makeText(this, "Reading SP, finished", Toast.LENGTH_LONG).show();
                break;
            case R.id.button_filein:
                try {
                    fos = openFileOutput(filename, MODE_PRIVATE);
                    String content = "heiheihei 123456";
                    fos.write(content.getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_fileout:
                try {
                    fis = openFileInput(filename);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    fis.close();
                    String content = new String(buffer);
                    Toast.makeText(this, content, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
