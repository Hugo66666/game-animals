package mg.studio.game.animals;

/**
 * Created by Administrator on 2018\3\23 0023.
 */


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    String arrayAnimalNames[] = {"bear", "bird", "cat", "elephant",
            "fish", "flower", "giraffe", "honey",
            "house", "hypo", "kangaroo", "leo",
            "lion", "pig", "rhino", "sun", "tiger",
            "wolf"};

    private int chance = 3;
    private int point = 0;

    TextView tv_animal_to_find;
    private String animalToFind;
    private ArrayList<Integer> imageIdNotToUseAgain;
    private ArrayList<String> nameOfImagesUsed;
    private ArrayList<Integer> imageIdNotToUseAgainBlackAndWhite;
    private int indexOfTheAnimalNameToFindInImageNotUsedAgain;
    private int arrayDrawableImagesIDs[];
    private Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        play();

    }


    public void btnClick(View view) {
        Log.d(getPackageName(), "btnClick(): " + view.getTag().toString());
        TextView info = (TextView) findViewById(R.id.chance);
        //如果点击正确的话
        if (animalToFind.equals(nameOfImagesUsed.get(Integer.valueOf(view.getTag().toString())))) {
            Log.d(getPackageName(), "btnClick(): " + nameOfImagesUsed.get(Integer.valueOf(view.getTag().toString())));
            //得分。下一个chanllege
            point++;
            info.setText("CHANCE:"+chance+"      POINT:"+point);
            if(point>9)
            {
                Intent intent = new Intent(PlayActivity.this, Win.class);
                intent.putExtra("point",point);
                intent.putExtra("chance",chance);
                startActivity(intent);
            }
            play();
            //ToDo 1 : Inform the user the choice was correct

            //Todo 2 : Keep track of the score as long as the application is not closed

            //Todo 3 : Generate a new challenge (at least 7 challenges needed before ending the game)

            //Todo 4 : Show a congratulating message if the user finishes all the challenges


        }
        //错误的话
        else {

            //Vibrate the phone  摇动手机
            vibrate();

            //Change the image into its black and white version
            ImageButton imageButton = (ImageButton) view;
            imageButton.setImageResource(imageIdNotToUseAgainBlackAndWhite.get(Integer.valueOf(view.getTag().toString())));

            //Animate the views to attract the user`s attention
            new Animations().shake(this, view);
            new Animations().shake(this, tv_animal_to_find);


            chance--;
            //机会小于0就死了
            if(chance<=0)
            {
                info.setText("CHANCE:"+chance+"      POINT:"+point);
                Intent intent = new Intent(PlayActivity.this, Lose.class);
                intent.putExtra("point",point);
                intent.putExtra("chance",chance);
                startActivity(intent);
            }
            //机会没有小于0就继续
            else
            {
                info.setText("CHANCE:"+chance+"      POINT:"+point);
            }
        }
    }

    //摇动
    private void vibrate() {
        // Get an instance of Vibrator from the current Context
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Check if the device has a vibrator
        if (vibrator.hasVibrator()) {
            Log.d(getPackageName(), "Device hasVibrator (): "+ vibrator.hasVibrator());
            //Check if the vibrator has amplitude control
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Log.d(getPackageName(), "hasAmplitudeControl (): "+ vibrator.hasAmplitudeControl());
            }
            // Vibrate the device for 400 milliseconds
            vibrator.vibrate(400);
        }
    }

    //按推出按钮
    @Override
    public void onBackPressed() {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppThemeDialog);


        // 2. Set an icon, in this case, we use the animal to find as the icon
        builder.setIcon(arrayDrawableImagesIDs[imageIdNotToUseAgain.get(indexOfTheAnimalNameToFindInImageNotUsedAgain)]);

        // 3. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Do you want to exit the game?")
                .setTitle(getTitle());

        // 4. Add the buttons
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button, end the App
                finishAffinity();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked NO, cancel the dialog
                dialog.cancel();
            }
        });

        // 5. Get the AlertDialog from create() the show
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    //play
    public void play(){
        tv_animal_to_find = findViewById(R.id.tv_animal_to_find);


        //图片数组
        arrayDrawableImagesIDs = new int[]{R.drawable.bear, R.drawable.bird, R.drawable.cat, R.drawable.elephant,
                R.drawable.fish, R.drawable.flower, R.drawable.giraffe, R.drawable.honey,
                R.drawable.house, R.drawable.hypo, R.drawable.kangaroo, R.drawable.leo,
                R.drawable.lion, R.drawable.pig, R.drawable.rhino, R.drawable.sun, R.drawable.tiger,
                R.drawable.wolf};

        //黑白图片数组
        int arrayDrawableImagesBalckWhiteIDs[] = {R.drawable.bear_black, R.drawable.bird_black, R.drawable.cat_black, R.drawable.elephant_black,
                R.drawable.fish_black, R.drawable.flower_black, R.drawable.giraffe_black, R.drawable.honey_black,
                R.drawable.house_black, R.drawable.hypo_black, R.drawable.kangaroo_black, R.drawable.leo_black,
                R.drawable.lion_black, R.drawable.pig_black, R.drawable.rhino_black, R.drawable.sun_black, R.drawable.tiger_black,
                R.drawable.wolf_black};

        ImageButton arrayButtonViews[] = {findViewById(R.id.btn_top_left), findViewById(R.id.btn_top_right),
                findViewById(R.id.btn_bottom_left), findViewById(R.id.btn_bottom_right)};


        imageIdNotToUseAgain = new ArrayList<>(); //Use this this to keep track of the image already used
        imageIdNotToUseAgainBlackAndWhite = new ArrayList<>();
        nameOfImagesUsed = new ArrayList<>(); //Keep track of the image names used

        //Get four random image to display in the app    随机图片
        for (ImageButton btnView : arrayButtonViews) {
            int indexOfWhatToUse;
            while (true) {
                indexOfWhatToUse = (int) (Math.random() * (arrayDrawableImagesIDs.length - 1));
                Log.d(getPackageName(), "indexOfWhatToUse: " + indexOfWhatToUse);
                if (!imageIdNotToUseAgain.contains(indexOfWhatToUse)) {
                    break;
                }
            }

            imageIdNotToUseAgain.add(indexOfWhatToUse);
            imageIdNotToUseAgainBlackAndWhite.add(arrayDrawableImagesBalckWhiteIDs[indexOfWhatToUse]);

            btnView.setImageResource(arrayDrawableImagesIDs[indexOfWhatToUse]);
            nameOfImagesUsed.add(arrayAnimalNames[indexOfWhatToUse]);

        }

        //From the four names, choose one that the use needs to find
        indexOfTheAnimalNameToFindInImageNotUsedAgain = new Random().nextInt(3) + 0;
        animalToFind = nameOfImagesUsed.get(indexOfTheAnimalNameToFindInImageNotUsedAgain);
        tv_animal_to_find.setText(animalToFind);
    }
}