package com.example.k01_ver_saklama;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);


        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.k01_ver_saklama", Context.MODE_PRIVATE);

        // Todo: Uygulamaya ikon eklenebilir.
        // Todo: Açıklayıcı metin ekle.
        // Todo: Readme tanıtım ve açıklama metni yaz.



    }


    @SuppressLint("CommitPrefEdits")
    public void buton(View view) {
        if (!editText.getText().toString().matches("")) {
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText("Your age : " + userAge);

            SharedPreferences.edit().putInt("storedAge",userAge).apply();


        }
    }
}