package addictsstudio.swipeswipe;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    private Switch snd;
    public Button Bts;
    public TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txt = new TextView(this);
        setContentView(R.layout.activity_settings);
        if (MainActivity.diff == 1)
        {
            txt=(TextView)findViewById(R.id.description);
            txt.setText("Easy:Piece of cake.");
        }
        if (MainActivity.diff == 2)
        {
            txt=(TextView)findViewById(R.id.description);
            txt.setText("Hard:Easy is too easy,right ?");
        }
        if (MainActivity.diff == 3)
        {
            txt=(TextView)findViewById(R.id.description);
            txt.setText("Too Hard:For guys think Hard just like Easy.");
        }
        onClickEasy();
        onClickHard();
        onClickTooHard();
    }
       public void savingPreferences()// lưu dữ liệu
    {
        //tạo đối tượng getSharedPreferences
        SharedPreferences pre=getSharedPreferences
                ("data", MODE_PRIVATE);
        //tạo đối tượng Editor để lưu thay đổi
        SharedPreferences.Editor editor=pre.edit();//lưu vào editor
              editor.putInt("Difficulty", MainActivity.diff);
        //chấp nhận lưu xuống file
        editor.commit();
    }

   /* public static int getDiff(){
        return diff;
    }*/

    public void onClickEasy(){

        Bts = (Button) findViewById(R.id.buttonEasy);
        Bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt=(TextView)findViewById(R.id.description);
                txt.setText("Easy:Piece of cake.");
                MainActivity.diff = 1;
                savingPreferences();
            }
        });
    }
    public void onClickHard(){
        Bts = (Button) findViewById(R.id.buttonHard);
        Bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt=(TextView)findViewById(R.id.description);
                txt.setText("Hard:Easy is too easy,right ?");
                MainActivity.diff =  2;
                savingPreferences();
            }
        });
    }
    public void onClickTooHard(){
        Bts = (Button) findViewById(R.id.buttonTooHard);
        Bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt=(TextView)findViewById(R.id.description);
                txt.setText("Too Hard:For guys think Hard just like Easy.");
                MainActivity.diff =  3;
                savingPreferences();
            }
        });
    }
}
