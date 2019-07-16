package com.aabiskar.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tfb.fbtoast.FBToast;

public class Memo extends AppCompatActivity {

    EditText et_memo;
    Button b_clear , b_save;
    String memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        et_memo = findViewById(R.id.et_memo);
        b_clear= findViewById(R.id.b_clear);
        b_save = findViewById(R.id.b_save);

        SharedPreferences preferences = getSharedPreferences("PREFS" , 0);
        memo = preferences.getString("memo", "");

        et_memo.setText(memo);

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memo = "";
                et_memo.setText(memo);

            }
        });
        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memo = et_memo.getText().toString();
                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("memo",memo);
                editor.commit();

                FBToast.successToast(Memo.this,"Memo saved", Toast.LENGTH_SHORT);

            }
        });


    }
}
