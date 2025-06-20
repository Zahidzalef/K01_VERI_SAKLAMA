package com.example.k01_ver_saklama;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.example.k01_ver_saklama",Context.MODE_PRIVATE);
        int storedAge = sharedPreferences.getInt("storedAge",0);
        if (storedAge == 0) {
            textView.setText("Your age : ");
        } else {
            textView.setText("Your age : "+ storedAge);
        }
        // Todo: Uygulamaya ikon eklenebilir.
        // Todo: Açıklayıcı metin ekle.
        // Todo: Readme tanıtım ve açıklama metni yaz.
        // Todo: editText'e sayı dışı verilere hata mesajı verdir.


    }

    public void buton(View view) {
        if (!editText.getText().toString().matches("")) {
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText("Your age : " + userAge);

            sharedPreferences.edit().putInt("storedAge",userAge).apply();;

        }
    }

    public void delete(View view) {
        int storedData = sharedPreferences.getInt("storedAge",0);
        if (storedData != 0) {
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your age : ");
        }
    }
}
