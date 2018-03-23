package com.example.a52641.animal_game;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Setting extends AppCompatActivity implements View.OnClickListener{

    int goal_number = 20;                       //通关需要的得分数
    int heart_number = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Intent intent = getIntent();
        goal_number = intent.getIntExtra("goal_number",20);
        heart_number = intent.getIntExtra("heart_number",3);

        //设置按钮的属性   set Button
        Typeface tp1 = Typeface.createFromAsset(getAssets(),"Fonts/04B_03.TTF");
        Button bt_back = (Button)findViewById(R.id.back_to_main);
        bt_back.setTypeface(tp1);
        bt_back.setOnClickListener(this);




        //设置选择通关得分的拖动条
        final SeekBar goal_seekBar = (SeekBar) findViewById(R.id.goal_seekBar);
        final TextView goal = (TextView) findViewById(R.id.goal);
        goal_seekBar.setProgress(goal_number-1);
        goal.setText("GOAL:" + goal_number);
        goal_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 当拖动条的滑块位置发生改变时触发该方法,在这里直接使用参数progress，即当前滑块代表的进度值
                int min_number = 1;
                goal.setText("GOAL:" + Integer.toString(progress+min_number));
                goal_number = progress+min_number;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        //设置选择血量的滚动条
        final SeekBar heart_seekBar = (SeekBar) findViewById(R.id.heart_seekBar);
        final TextView heart = (TextView) findViewById(R.id.heart);
        heart_seekBar.setProgress(heart_number-1);
        heart.setText("HEART:" + heart_number);
        heart_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 当拖动条的滑块位置发生改变时触发该方法,在这里直接使用参数progress，即当前滑块代表的进度值
                int min_number = 1;
                heart.setText("HEART:" + Integer.toString(progress+min_number));
                heart_number = progress+min_number;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });





    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.back_to_main)
        {
            Intent intent = new Intent(Setting.this, MainActivity.class);
            intent.putExtra("goal_number",goal_number);
            intent.putExtra("heart_number",heart_number);
            startActivity(intent);
            Setting.this.finish();
        }
    }
}
