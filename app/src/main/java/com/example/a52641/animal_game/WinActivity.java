package com.example.a52641.animal_game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        TextView bt_return = (TextView) findViewById(R.id.again);
        bt_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.again:
                Intent intent = new Intent(WinActivity.this, MainActivity.class);
                startActivity(intent);
                WinActivity.this.finish();
                break;
        }
    }
}
