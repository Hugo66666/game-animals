package mg.studio.game.animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Win extends AppCompatActivity implements View.OnClickListener {

    private int chance = 3;
    private int point = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        //获得point和chance
        Intent intent = getIntent();
        chance = intent.getIntExtra("chance",3);
        point = intent.getIntExtra("point",0);

        Button bt = (Button) findViewById(R.id.back_to_main);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.back_to_main)
        {
            Intent intent = new Intent(Win.this, MainActivity.class);
            intent.putExtra("point",point);
            intent.putExtra("chance",chance);
            startActivity(intent);
        }
    }
}
