package com.example.multipleactivitiesfun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    static final String TAG = "MultipleActivityFunTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //2. get data from main
        Intent intent = getIntent();
        if(intent != null){
            String username = intent.getStringExtra("username");
            //getStringExtra returns null if it doesn't find username
            int pin = intent.getIntExtra("pin", 0);
            //getIntExtra returns 0 if it doesn't find pin
            Toast.makeText(this, username + " " + pin, Toast.LENGTH_SHORT).show();
        }

        Button startButton = (Button) findViewById(R.id.backToMain);
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //3. send a result back to MainActivity
                Intent intent = new Intent();
                intent.putExtra("result", "successful");
                setResult(Activity.RESULT_OK, intent);
                SecondActivity.this.finish();
            }
        });
    }
}
