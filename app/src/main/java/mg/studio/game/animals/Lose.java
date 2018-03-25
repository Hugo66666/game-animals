package mg.studio.game.animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lose extends AppCompatActivity implements View.OnClickListener{

    private int chance = 3;
    private int point = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        //获得point和chance
        Intent intent = getIntent();
        chance = intent.getIntExtra("chance",3);
        point = intent.getIntExtra("point",0);

        //获得文本框
        TextView tv =(TextView) findViewById(R.id.info);
        tv.setText("You got "+point+" points!");

        Button bt = (Button) findViewById(R.id.return_to_main);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.return_to_main)
        {
            Intent intent = new Intent(Lose.this, MainActivity.class);
            intent.putExtra("point",point);
            intent.putExtra("chance",chance);
            startActivity(intent);
        }
    }
}
