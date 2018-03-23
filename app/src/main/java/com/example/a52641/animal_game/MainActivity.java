package com.example.a52641.animal_game;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int goal_number=20;
    int heart_number=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        goal_number = intent.getIntExtra("goal_number",20);
        heart_number = intent.getIntExtra("heart_number",3);

        Typeface tp1 = Typeface.createFromAsset(getAssets(),"Fonts/04B_03.TTF");
        Button bt_play = (Button)findViewById(R.id.bt_play);
        Button bt_settings = (Button)findViewById(R.id.bt_settings);
        bt_play.setTypeface(tp1);
        //bt_play.setEnabled(false);
        bt_play.setOnClickListener(this);
        bt_settings.setTypeface(tp1);
        bt_settings.setOnClickListener(this);
        //bt_settings.setEnabled(false);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_play:
                //此处是开始游戏按钮的响应    the response for bt_play
                Intent intent = new Intent(MainActivity.this, Playing.class);
                intent.putExtra("goal_number",goal_number);
                intent.putExtra("heart_number",heart_number);
                startActivity(intent);
                MainActivity.this.finish();
                break;
            case R.id.bt_settings:
                //此处是设置的响应    the response for bt_settings
                Intent intent2 = new Intent(MainActivity.this, Setting.class);
                intent2.putExtra("goal_number",goal_number);
                intent2.putExtra("heart_number",heart_number);
                startActivity(intent2);
                break;
        }
    }
}
