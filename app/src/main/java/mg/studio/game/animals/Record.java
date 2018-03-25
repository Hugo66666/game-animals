package mg.studio.game.animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Record extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        ArrayList list = getIntent().getStringArrayListExtra("arr");


        if(list.get(1)!=null) {
            TextView t1 = (TextView) findViewById(R.id.t1);
            t1.setText(list.get(0) + " ");

            TextView t2 = (TextView) findViewById(R.id.t2);
            t2.setText(String.valueOf(list.get(1)));

            TextView t3 = (TextView) findViewById(R.id.t3);
            t3.setText(String.valueOf(list.get(2)));

            TextView t4 = (TextView) findViewById(R.id.t4);
            t4.setText(String.valueOf(list.get(3)));

            TextView t5 = (TextView) findViewById(R.id.t5);
            t5.setText(String.valueOf(list.get(4)));

            TextView t6 = (TextView) findViewById(R.id.t6);
            t6.setText(String.valueOf(list.get(5)));

            TextView t7 = (TextView) findViewById(R.id.t7);
            t7.setText(String.valueOf(list.get(6)));

            TextView t8 = (TextView) findViewById(R.id.t8);
            t8.setText(String.valueOf(list.get(7)));

            TextView t9 = (TextView) findViewById(R.id.t9);
            t9.setText(String.valueOf(list.get(8)));

            TextView t10 = (TextView) findViewById(R.id.t10);
            t10.setText(String.valueOf(list.get(9)));


        }


        Button bt = (Button) findViewById(R.id.rt);
        bt.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.rt)
        {
            Intent intent = new Intent(Record.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
