package com.example.huddar_p.navtrial1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

/**
 * Created by narayanswamy_s on 20-09-2017.
 */

public class TimerClass extends Activity {

    TextView displayText;
    public int seconds = 3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.timer);

        final Handler handler = new Handler();
        displayText=(TextView)findViewById(R.id.displayTimer);

        handler.post(new Runnable() {
            @Override
            public void run() {
                if(seconds > 0)
                {
                    seconds--;
                    displayText.setText(Integer.toString(seconds));
                    handler.postDelayed(this,1000);
                }
                else
                {
                    Intent myIntent = new Intent(TimerClass.this,hiit_activity.class);
                    startActivity(myIntent);
                }
            }
        });
    }

}