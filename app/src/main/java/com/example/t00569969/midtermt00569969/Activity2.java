package com.example.t00569969.midtermt00569969;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    int eggs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView dozen= (TextView)(findViewById(R.id.dozenView));
        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if(intent.hasExtra(MainActivity.EXTRA_MESSAGE)) {
            eggs = Integer.parseInt(message);
        }else {
            SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        }
        int eggsres=eggs/12;
        dozen.setText("You have\n "+eggsres+" dozen");
    }
    @Override
    protected void onStop(){
        super.onStop();
        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("egg value",eggs);

        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("egg value", eggs);

        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("egg value", eggs);

        editor.commit();
    }
}
