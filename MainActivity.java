package addictsstudio.swipeswipe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button Bts;
    public static Integer diff;
    public static Integer hiscore;
    public TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        diff = 1;
        //savingPreferences();
        restoringPreferences();
        txt = new TextView(this);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.hiscr);
        String s = "" + hiscore;
        txt.setText(s);
        onClickStart();
        onClickSettings();
    }

 public void restoringPreferences() // lấy dữ liệu
 {
     SharedPreferences pre=getSharedPreferences("data",MODE_PRIVATE);
     diff =pre.getInt("Difficulty",1);
     hiscore = pre.getInt("highscore",0);
 }

    public void onClickStart(){
        Bts = (Button) findViewById(R.id.buttonStart);
        Bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("addictsstudio.swipeswipe.GamePlay");
                startActivity(intent);
            }
        });
    }

    public void onClickSettings(){
        Bts = (Button) findViewById(R.id.buttonSettings);
        Bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("addictsstudio.swipeswipe.Settings");
                startActivity(intent);
            }
        });
    }

}
