package com.example.a52641.animal_game;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface tp1 = Typeface.createFromAsset(getAssets(),"Fonts/04B_03.TTF");
        Button bt_play = (Button)findViewById(R.id.bt_play);
        Button bt_settings = (Button)findViewById(R.id.bt_settings);
        bt_play.setTypeface(tp1);
        //bt_play.setEnabled(false);
        bt_play.setOnClickListener(this);
        bt_settings.setTypeface(tp1);
        //bt_settings.setEnabled(false);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_play:
                //此处是开始游戏按钮的响应    the response for bt_play
                Intent intent = new Intent(MainActivity.this, Playing.class);
                startActivity(intent);
                MainActivity.this.finish();
                break;
            case R.id.bt_settings:
                //此处是设置的响应    the response for bt_settings
                break;
        }
    }
}
