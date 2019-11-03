package com.example.multipleactivitiesfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Intent intent = getIntent();
        //good practice
        if(intent != null){
            String action = intent.getAction(); //Intent.ACTION_SEND
            String type = intent.getType(); //text/plain
            //good practice
            if(action.equals(Intent.ACTION_SEND) && type.equals("text/plain")) {
                //safe to get the message
                String message = intent.getStringExtra(Intent.EXTRA_TEXT);
                TextView v = (TextView) findViewById(R.id.shareTextView);
                v.setText(message);
                //edit in AndroidManifest.xml to say we can use this Activity to send
            }
        }
    }
}
