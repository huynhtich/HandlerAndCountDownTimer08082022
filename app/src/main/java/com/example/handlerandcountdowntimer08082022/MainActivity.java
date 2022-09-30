package com.example.handlerandcountdowntimer08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    ImageView imageView;
    Button btnStart, btnPause;
    int[] arrImage = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};;
    int count = 0;
    boolean isRunning = false;
    boolean isPause = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view_banner);
        btnStart = findViewById(R.id.button_start);
        btnPause = findViewById(R.id.button_pause);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isRunning) {
                    isRunning = true;
                    countDownTimer = new CountDownTimer(1200, 1000) {
                        @Override
                        public void onTick(long l) {

                            count = count == arrImage.length - 1 ? 0 : count;

                            if(l > 1000) {
                                imageView.setImageResource(arrImage[count++]);
                            }
                        }

                        @Override
                        public void onFinish() {
                            countDownTimer.start();
                        }
                    }.start();    
                } else {
                    Toast.makeText(MainActivity.this, "Banner đang chạy", Toast.LENGTH_SHORT).show();
                }
                
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPause) {
                    countDownTimer.cancel();
                    isPause = true;
                } else {
                    isRunning = false;
                    countDownTimer.start();
                    isPause = false;
                }

            }
        });


    }
}