package com.tweetposter.stemcontweetposter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtUpdate = (EditText) findViewById(R.id.txtUpdate);

        final Button btnSendTweet = (Button) findViewById(R.id.btnSendTweet);
        btnSendTweet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Post Tweet with
                new Tweeter().execute(txtUpdate.getText().toString());
            }
        });
    }



}

