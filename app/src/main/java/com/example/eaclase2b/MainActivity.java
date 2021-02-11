package com.example.eaclase2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter1 = 0;
    private TextView counter1TV;
    private Button playBtn;
    private Button stopBtn;
    private boolean counterIsPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter1TV = findViewById(R.id.counter1TV);


        playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(
                v -> {
                    if (counterIsPlaying == false) {
                        playCounter();
                    } else {
                        Toast.makeText(this, "Ya está corriendo", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        stopBtn = findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(
                v -> {
                    counterIsPlaying = false;
                }
        );

    }
        public void playCounter(){
            counterIsPlaying = true;
            new Thread(
                    () -> {
                        while (counterIsPlaying){
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            counter1++;
                            Log.e(">>>",""+counter1);
                            runOnUiThread(
                                    ()->{
                                        counter1TV.setText(""+counter1);
                                    }
                            );
                        }
                    }
            ).start();
        }
}
