package com.qooke.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // 화면에 있는 뷰를 가져온다.
    // 멤버변수(클래스 변수)

    Button btnDice;
    ImageView imgDice1;
    ImageView imgDice2;

    // 소리나게 하는 미디어 플레이어를 변수로 만든다.
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰를 연결한다. 화면에 있는 것과 자바 코드랑 연결, 변수에 저장
        btnDice = findViewById(R.id.btnDice);
        imgDice1 = findViewById(R.id.imgDice1);
        imgDice2 = findViewById(R.id.imgDice2);

        // 미디어 플레이어 준비
        mp = MediaPlayer.create(this, R.raw.dice_sound);

        btnDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼 눌렀을때 하고 싶은 일을 여기에 작성하는 것이다.

                // 0. 주사위 굴리는 소리를 낸다.
                mp.start();

                // 1. 랜덤으로 숫자를 가져온다. 2개!
                Random random = new Random();
                int num1 = random.nextInt(6); // 0~5까지의 랜덤정수 가져와라
                int num2 = random.nextInt(6);

                // 2. 화면의 이미지를 숫자에 맞게 바꿔준다.
                // 주사위 1(imgDice1)
                if (num1 == 0) {
                    imgDice1.setImageResource(R.drawable.dice1);
                } else if (num1 == 1) {
                    imgDice1.setImageResource(R.drawable.dice2);
                } else if (num1 == 2) {
                    imgDice1.setImageResource(R.drawable.dice3);
                } else if (num1 == 3) {
                    imgDice1.setImageResource(R.drawable.dice4);
                } else if (num1 == 4) {
                    imgDice1.setImageResource(R.drawable.dice5);
                } else if (num1 == 5) {
                    imgDice1.setImageResource(R.drawable.dice6);
                }

                // 주사위 2(imgDice2)
                if (num2 == 0) {
                    imgDice2.setImageResource(R.drawable.dice1);
                } else if (num2 == 1) {
                    imgDice2.setImageResource(R.drawable.dice2);
                } else if (num2 == 2) {
                    imgDice2.setImageResource(R.drawable.dice3);
                } else if (num2 == 3) {
                    imgDice2.setImageResource(R.drawable.dice4);
                } else if (num2 == 4) {
                    imgDice2.setImageResource(R.drawable.dice5);
                } else if (num2 == 5) {
                    imgDice2.setImageResource(R.drawable.dice6);
                }

                // 3. 애니메이션 효과를 준다.
                YoYo.with(Techniques.Shake).duration(400).repeat(0).playOn(imgDice1);
                YoYo.with(Techniques.Shake).duration(400).repeat(0).playOn(imgDice2);
            }
        });

    }
}