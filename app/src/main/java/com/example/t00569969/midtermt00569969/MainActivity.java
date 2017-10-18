package com.example.t00569969.midtermt00569969;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int eggcount;
    public static String EXTRA_MESSAGE = "com.example.t00569969.midtermt00569969.MESSAGE";
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eggcount=0;
        final TextView eggdisplay= (TextView)(findViewById(R.id.textView));
        ImageButton eggimg = (ImageButton)(findViewById(R.id.egg));
        Button add =(Button)(findViewById(R.id.addition));
        Button sub =(Button)(findViewById(R.id.subtract));
        final Intent toact= new Intent(this,Activity2.class);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        eggdisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Message = String.valueOf(eggcount);
                toact.putExtra(EXTRA_MESSAGE,Message);
                startActivity(toact);
            }
        });
        eggimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Message = String.valueOf(eggcount);
                toact.putExtra(EXTRA_MESSAGE,Message);
                startActivity(toact);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eggcount++;
                eggdisplay.setText(String.valueOf(eggcount));
                //add more
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eggcount--;
                eggdisplay.setText(String.valueOf(eggcount));
            }
        });
    }
    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("egg value", eggcount);

        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("egg value", eggcount);

        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
