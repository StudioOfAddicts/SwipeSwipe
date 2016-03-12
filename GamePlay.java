package addictsstudio.swipeswipe;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GamePlay extends AppCompatActivity {
    public TextView txt,tx,t;
    DetectSwipeGesture Dsg;
    static MotionEvent ev;
    public static float x1, x2, y1, y2, x, y,dodai;
    public static int INT;
    public int score;
    ProgressBar PB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txt = new TextView(this);
        tx = new TextView(this);
        t = new TextView(this);
        setContentView(R.layout.activity_game_play);
        txt = (TextView) findViewById(R.id.diffView);
        String s = "" + MainActivity.diff;
        txt.setText(s);

    }
   public void savingPreferences()
    {
        //tạo đối tượng getSharedPreferences
        SharedPreferences pre=getSharedPreferences
                ("data", MODE_PRIVATE);
        //tạo đối tượng Editor để lưu thay đổi
        SharedPreferences.Editor editor=pre.edit();
        //lưu vào editor
        editor.putInt("highscore", MainActivity.hiscore);
        //editor.putInt("Difficulty", 3);
        //chấp nhận lưu xuống file
        editor.commit();
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev){
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                x1 = ev.getX();
                y1 = ev.getY();
                break;
            }
            case MotionEvent.ACTION_UP: {
                x2 = ev.getX();
                y2 = ev.getY();
                x = x2 - x1;
                y = y2 - y1;
                dodai = (float) Math.sqrt(x * x + y * y);
                if (dodai > 100) {
                    if (Up()) INT = 3;
                    else if (Right()) INT = 2;
                    else if (Down()) INT = 1;
                    else if (Left()) INT = 4;
                    else INT = 0;
                }else  INT = 0;
                txt = (TextView) findViewById(R.id.movement);
                tx = (TextView) findViewById(R.id.timer);
                String s = ""+ INT;
                txt.setText(s);
                if (INT != 0) {
            PB = (ProgressBar) findViewById(R.id.progressBar);
                PB.setMax(10000);
                    new CountDownTimer(10000, 1) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            tx.setText("" + millisUntilFinished / 1000);
                            PB.setProgress((int) millisUntilFinished);
                        }


                        public void onFinish() {
                            tx.setText("Doom !");
                        }
                    }.start();
                    score++;
                    t = (TextView) findViewById(R.id.scr);
                    t.setText(""+score);
                    if (score > MainActivity.hiscore)
                    {
                        MainActivity.hiscore = score;
                        savingPreferences();
                    }
                }
            }
        }
        return false;
    }

    public static boolean Left(){
        return (x<0 && Math.abs(x/y)>2);
    }

    public static boolean Right(){
        return (x>0 && Math.abs(x/y)>2);
    }

    public static boolean Up(){
        return (y>0 && Math.abs(y/x)>2);
    }

    public static boolean Down(){
        return (y<0 && Math.abs(y/x)>2);
    }


}