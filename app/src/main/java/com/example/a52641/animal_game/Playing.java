package com.example.a52641.animal_game;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class Playing extends AppCompatActivity implements View.OnClickListener {

    private String[] animals = new String[]{
            "bear","bird","cat","elephant","fish","flower","giraffe","honey","house","hypo","kangaroo","leo","lion","pig","rhino","sun","tiger","wolf"
    };

    private int[] pic_num = new int[]{1,2,3,4};
    private int intRd=0,right_num=0;    //记录随机数  record random number
    int flag = 0;           //已经生成随机数与否的标志
    int count = 0;         //记录第几个随机数
    int score_count = 0;     //记录得分
    int heart_count = 3;    //记录生命值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);


        Play_game();

    }

    @Override
    public void onClick(View v) {
        //获取字体    font
        Typeface tp1 = Typeface.createFromAsset(getAssets(),"Fonts/ARBERKLEY.ttf");
        TextView result = (TextView) findViewById(R.id.result);
        result.setTypeface(tp1);

        TextView score = (TextView) findViewById(R.id.score);
        score.setText(score_count+"");
        switch(v.getId()) {
            case R.id.pic_1:
                if(right_num==0)    //答对
                {
                    playSound(R.raw.right);
                    score_count++;
                    if(score_count<=20) {
                        result.setText("Right!");
                        result.setTextColor((Color.parseColor("#7CFC00")));
                        Play_game();
                    }
                    else
                    {
                        Intent intent = new Intent(Playing.this, WinActivity.class);
                        startActivity(intent);
                        Playing.this.finish();
                    }
                }
                    else        //答错
                {
                    playSound(R.raw.wrong);
                    result.setText("Wrong!");
                    result.setTextColor((Color.parseColor("#EE0000")));
                    heart_count--;
                    if(heart_count>0)
                    Play_game();
                    else
                    {
                        Intent intent = new Intent(Playing.this, DeadActivity.class);
                        startActivity(intent);
                        Playing.this.finish();
                    }
                }
                break;
            case R.id.pic_2:
                if(right_num==1)    //答对
                {
                    playSound(R.raw.right);
                    score_count++;
                    if(score_count<=20) {
                        result.setText("Right!");
                        result.setTextColor((Color.parseColor("#7CFC00")));
                        Play_game();
                    }
                    else
                    {
                        Intent intent = new Intent(Playing.this, WinActivity.class);
                        startActivity(intent);
                        Playing.this.finish();
                    }
                }
                else       //答错
                {
                    playSound(R.raw.wrong);
                    result.setText("Wrong!");
                    result.setTextColor((Color.parseColor("#EE0000")));
                    heart_count--;
                    if(heart_count>0)
                        Play_game();
                    else
                    {
                        Intent intent = new Intent(Playing.this, DeadActivity.class);
                        startActivity(intent);
                        Playing.this.finish();
                    }
                }
                break;
            case R.id.pic_3:
                if(right_num==2)    //答对
                {
                    playSound(R.raw.right);
                    score_count++;
                    if(score_count<=20) {
                        result.setText("Right!");
                        result.setTextColor((Color.parseColor("#7CFC00")));
                        Play_game();
                    }
                    else
                    {
                        Intent intent = new Intent(Playing.this, WinActivity.class);
                        startActivity(intent);
                        Playing.this.finish();
                    }
                }
                else        //答错
                {
                    playSound(R.raw.wrong);
                    result.setText("Wrong!");
                    result.setTextColor((Color.parseColor("#EE0000")));
                    heart_count--;
                    if(heart_count>0)
                        Play_game();
                    else
                    {
                        Intent intent = new Intent(Playing.this, DeadActivity.class);
                        startActivity(intent);
                        Playing.this.finish();
                    }
                }
                break;
            case R.id.pic_4:
                if(right_num==3)    //答对
                {
                    playSound(R.raw.right);
                    score_count++;
                    if(score_count<=20) {
                        result.setText("Right!");
                        result.setTextColor((Color.parseColor("#7CFC00")));
                        Play_game();
                    }
                    else
                    {
                        Intent intent = new Intent(Playing.this, WinActivity.class);
                        startActivity(intent);
                        Playing.this.finish();
                    }
                }
                else       //答错
                {
                    playSound(R.raw.wrong);
                    result.setText("Wrong!");
                    result.setTextColor((Color.parseColor("#EE0000")));
                    heart_count--;
                    if(heart_count>0)
                        Play_game();
                    else
                    {
                        Intent intent = new Intent(Playing.this, DeadActivity.class);
                        startActivity(intent);
                        Playing.this.finish();
                    }
                }
                break;
        }
    }

    /**
     * 从Assets中读取图片
     */
    private Bitmap getImageFromAssetsFile(String fileName)
    {
        Bitmap image = null;
        AssetManager am = getResources().getAssets();
        try
        {
            InputStream is = am.open("png/"+fileName+"/256w/"+fileName+"Artboard 1xxxhdpi.png");
            image = BitmapFactory.decodeStream(is);
            is.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return image;

    }

    private void Play_game(){
        //显示得分
        TextView score = (TextView) findViewById(R.id.score);
        score.setText(score_count+"");
        //显示血量
        TextView heart_num = (TextView) findViewById(R.id.heart_number);
        heart_num.setText("heart:"+heart_count);

        //****************************************生成图片随机数  picture random*************************************
        Random right = new Random();
        right_num = Math.abs(right.nextInt())%4;           //获取正确的那个
        count = 0;
        while (count < 4) {
            Random random = new Random(System.currentTimeMillis());
            intRd = Math.abs(random.nextInt()) % animals.length;       //生成动物种类数的随机数
            for (int i = 0; i < count; i++)
                if (pic_num[i] == intRd) {
                    flag = 1;
                    break;
                } else {
                    flag = 0;
                }

            if (flag == 0) {
                pic_num[count] = intRd;
                count++;
            }
        }
        //**********************************************随机数生成结束*************************************************


        //获取各种控件id    get button id
        ImageButton Img_1 = (ImageButton) findViewById(R.id.pic_1);
        ImageButton Img_2 = (ImageButton) findViewById(R.id.pic_2);
        ImageButton Img_3 = (ImageButton) findViewById(R.id.pic_3);
        ImageButton Img_4 = (ImageButton) findViewById(R.id.pic_4);
        TextView animal_name = (TextView) findViewById(R.id.animal_name);

        //设置消息相应
        Img_1.setOnClickListener(this);
        Img_2.setOnClickListener(this);
        Img_3.setOnClickListener(this);
        Img_4.setOnClickListener(this);

        Bitmap bmp_1 = getImageFromAssetsFile(animals[pic_num[0]]);
        Bitmap bmp_2 = getImageFromAssetsFile(animals[pic_num[1]]);
        Bitmap bmp_3 = getImageFromAssetsFile(animals[pic_num[2]]);
        Bitmap bmp_4 = getImageFromAssetsFile(animals[pic_num[3]]);

        //设置背景透明   set background transparent
        Img_1.setBackgroundColor(Color.TRANSPARENT);
        Img_2.setBackgroundColor(Color.TRANSPARENT);
        Img_3.setBackgroundColor(Color.TRANSPARENT);
        Img_4.setBackgroundColor(Color.TRANSPARENT);

        Img_1.setImageBitmap(bmp_1);
        Img_2.setImageBitmap(bmp_2);
        Img_3.setImageBitmap(bmp_3);
        Img_4.setImageBitmap(bmp_4);

        animal_name.setText(animals[pic_num[right_num]]);
    }


    /**
     * 适合播放声音短，文件小
     * 可以同时播放多种音频
     * 消耗资源较小
     */
    public void playSound(int rawId) {
        SoundPool soundPool;
        if (Build.VERSION.SDK_INT >= 21) {
            SoundPool.Builder builder = new SoundPool.Builder();
            //传入音频的数量
            builder.setMaxStreams(1);
            //AudioAttributes是一个封装音频各种属性的类
            AudioAttributes.Builder attrBuilder = new AudioAttributes.Builder();
            //设置音频流的合适属性
            attrBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC);
            builder.setAudioAttributes(attrBuilder.build());
            soundPool = builder.build();
        } else {
            //第一个参数是可以支持的声音数量，第二个是声音类型，第三个是声音品质
            soundPool = new SoundPool(1, AudioManager.STREAM_SYSTEM, 5);
        }
        //第一个参数Context,第二个参数资源Id，第三个参数优先级
        soundPool.load(getApplicationContext(), rawId, 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                soundPool.play(1, 1, 1, 0, 0, 1);
            }
        });
        //第一个参数id，即传入池中的顺序，第二个和第三个参数为左右声道，第四个参数为优先级，第五个是否循环播放，0不循环，-1循环
        //最后一个参数播放比率，范围0.5到2，通常为1表示正常播放
//        soundPool.play(1, 1, 1, 0, 0, 1);
        //回收Pool中的资源
        //soundPool.release();

    }

}
