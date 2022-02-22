package com.example.video33_37_kpham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int score = 100;
    TextView textViewScore;
    CheckBox checkBox1, checkBox2, checkBox3;
    SeekBar seekBar1, seekBar2, seekBar3;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unit();

        textViewScore.setText(score + "");
        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                seekBar1.setProgress(seekBar1.getProgress() + one);
                seekBar2.setProgress(seekBar2.getProgress() + two);
                seekBar3.setProgress(seekBar3.getProgress() + three);

//                CHECK WHO IS WINNER

                if(seekBar1.getProgress() >= seekBar1.getMax()){
                    this.cancel();
                    imageButton.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,
                            "Ngô Đôn Win",
                            Toast.LENGTH_SHORT).show();

                    if(checkBox1.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this,
                                "Đúng +10 điểm",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        score -= 10;
                        Toast.makeText(MainActivity.this,
                                "Sai -10 điểm",
                                Toast.LENGTH_SHORT).show();
                    }
                    textViewScore.setText(score + "");
                    EnableCheckBox();
                }
                if(seekBar2.getProgress() >= seekBar2.getMax()){
                    this.cancel();
                    imageButton.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,
                            "Tùng Ngô Win",
                            Toast.LENGTH_SHORT).show();

                    if(checkBox2.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this,
                                "Đúng +10 điểm",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        score -= 10;
                        Toast.makeText(MainActivity.this,
                                "Sai -10 điểm",
                                Toast.LENGTH_SHORT).show();
                    }
                    textViewScore.setText(score + "");
                    EnableCheckBox();
                }
                if(seekBar3.getProgress() >= seekBar3.getMax()){
                    this.cancel();
                    imageButton.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,
                            "John Xina Win",
                          Toast.LENGTH_SHORT).show();

                    if(checkBox3.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this,
                                "Đúng +10 điểm",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        score -= 10;
                        Toast.makeText(MainActivity.this,
                                "Sai -10 điểm",
                                Toast.LENGTH_SHORT).show();
                    }
                    textViewScore.setText(score + "");
                    EnableCheckBox();
                }
            }

            @Override
            public void onFinish() {

            }
        };
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()){
                    seekBar1.setProgress(0);
                    seekBar2.setProgress(0);
                    seekBar3.setProgress(0);

                    imageButton.setVisibility(View.INVISIBLE);
//                Ẩn button
                    countDownTimer.start();
                    seekBar1.setEnabled(false);
                    seekBar2.setEnabled(false);
                    seekBar3.setEnabled(false);

                    DisenableCheckBox();
                }else{
                    Toast.makeText(MainActivity.this,
                            "Chọn 1 trong 3 đi",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBox1.setChecked(false);
                checkBox3.setChecked(false);
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
            }
        });

    }
    private void DisableSeekBar(){
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
    }

    private  void EnableCheckBox(){
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
    }

    private void DisenableCheckBox(){
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);

    }
    private void unit(){
        textViewScore = findViewById(R.id.textviewScore);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        seekBar1 = findViewById(R.id.seekbar1);
        seekBar2 = findViewById(R.id.seekbar2);
        seekBar3 = findViewById(R.id.seekbar3);
        imageButton = findViewById(R.id.imagebutton);
        DisableSeekBar();
    }
}