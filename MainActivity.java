package addictsstudio.tryshakeanim;

import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShakeImage(View v){
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        MediaPlayer mp = MediaPlayer.create(this,R.raw.horn);
        findViewById(R.id.imageView).startAnimation(shake);
        mp.start();
    }

    public void doNothing(View v){

    }

}
