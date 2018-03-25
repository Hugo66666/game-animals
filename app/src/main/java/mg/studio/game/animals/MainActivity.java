package mg.studio.game.animals;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int chance = 3;
    private int point = 0;
    private int[] arr = new int[]{0,0,0,0,0,0,0,0,0,0};
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得point和chance
        Intent intent = getIntent();
        chance = intent.getIntExtra("chance",3);
        point = intent.getIntExtra("point",0);
        int count=0;
        while(count<=9) {
            if(arr[count]!=0)
            count++;
            else
                break;
        }
        if(count>9)   count=0;
        arr[count] = point;

        for(int i=0; i<10; i++)
            arrayList.add(arr[i]);
        //Animate the text Animals
        new Animations().shake(this, findViewById(R.id.tv_animals));

    }


    public void btnStart(View view) {
        //to do when the button is clicked
        startActivity(new Intent(MainActivity.this, PlayActivity.class));
    }

    public void btnHowTo(View view) {
        //to do when the button is clicked
        //hoToPlay();

        //Bundle b=new Bundle();
        //b.putStringArray("record", arr);

        Intent intent = new Intent(MainActivity.this, Record.class);
        intent.putIntegerArrayListExtra("arr",arrayList);
        startActivity(intent);


    }

    private void hoToPlay() {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppThemeNoActionBar);


        // 3. Chain together various setter methods to set the dialog characteristics
        builder.setView(R.layout.how_to_play);


        // 5. Get the AlertDialog from create() the show
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
