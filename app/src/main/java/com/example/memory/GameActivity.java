package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {


    boolean isShowing = false;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    //Integer X;
    LinearLayout gamelayout;

    /*public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }*/
    boolean running = true;
    int A=3, counter = 0, B;
    int[][] color = new int[][]{
            {244, 241, 222},
            {242, 204, 143},
            {186, 191, 149},
            {234, 182, 159},
            {129, 178, 154},
            {95, 121, 123},
            {224, 122, 95},
            {143, 93, 93},
            {61, 64, 91}
    };
    int score = 0;
    TextView textView;
    ArrayList<Integer> list = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //GameView gameView = new GameView(this); // создаём gameView
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        gamelayout = findViewById(R.id.gameLayout);
        textView = findViewById(R.id.textView);
        //setContentView(R.layout.activity_game);
        //setUserTypeOnButtonClick();

        method();





       /* button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(224, 122, 95)));
            }
        });**/
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Log", "++");
                switch (v.getId()) {
                    case R.id.button1:
                        /*Color.rgb(244, 241, 222);
                        ColorStateList.valueOf(
                                Color.rgb(244, 241, 222));*/
                        //gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(244, 241, 222)));
                        B = 0;
                        break;
                    case R.id.button2:
                        //gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(242, 204, 143)));
                        B = 1;
                        break;
                    case R.id.button3:
                        //gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(186, 191, 149)));
                        B = 2;
                        break;
                    case R.id.button4:
                        //gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(234, 182, 159)));
                        B = 3;
                        break;
                    case R.id.button5:
                        //gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(129, 178, 154)));
                        B = 4;
                        break;
                    case R.id.button6:
                        //gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(95, 121, 123)));
                        B = 5;
                        break;
                    case R.id.button7:
                        //gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(224, 122, 95)));
                        B = 6;
                        break;
                    case R.id.button8:
                        //gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(143, 93, 93)));
                        B = 7;
                        break;
                    case R.id.button9:
                        //gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(61, 64, 91)));
                        B = 8;
                        break;
                    case R.id.button:
                        counter++;
                        break;
                }
                if (counter < list.size()) {
                    if (list.get(counter) == B) {
                        counter++;

                    } else {
                        textView.setText("GAME OVER");
                        //*SENDERRORMESSAGE *;
                        gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(255, 0, 0)));
                        //button1.setSystemUiVisibility(0);
                        score=0;
                        textView.setText
                                (Integer.toString(score));
                    }
                }
                if (counter == list.size()) {
                    score++;
                    counter=0;
                    method();
                    textView.setText
                            (Integer.toString(score));
                }


            }


        };
        button.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);

    }

    /*private void setUserTypeOnButtonClick() {
    }*/

    private void display() {
        gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(224, 122, 95)));
    }

    private void method() {
//        A = (int) ((Math.random() * 9));
        A = (A+2)%9;
        list.add(A);

        for (int i = 0; i < list.size(); i++) {
            AnotherThread thread = new AnotherThread();
            thread.start();
        }
    }

    public class AnotherThread extends Thread {
        @Override
        public void run() {
            gamelayout.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(0, 0, 0)));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < list.size(); i++) {
                try {
                    gamelayout.setBackgroundTintList(ColorStateList.valueOf
                            (Color.rgb(color[list.get(i)][0], color[list.get(i)][1],
                                    color[list.get(i)][2])));
                    Thread.sleep(1000);
                    gamelayout.setBackgroundTintList(ColorStateList.valueOf
                            (Color.rgb(0, 0, 0)));

                    Thread.sleep(1000);//Приостанавливает поток на 1 секунду
                } catch (InterruptedException e) {

                }
            }

        }

        public void requestStop() {
        }

    }


}