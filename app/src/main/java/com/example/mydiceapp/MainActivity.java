package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView dice1image=findViewById(R.id.dice1);
        ImageView dice2image= findViewById(R.id.dice2);
        //for sound when we click the button
        final MediaPlayer mp= MediaPlayer.create(this, R.raw.dice_sound);
        //array to change the image using random number gernerator
        int [] diceimages={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        Button btnroll= findViewById(R.id.rolldice);
        btnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rndobj= new Random();
                int rndnumber1= rndobj.nextInt(5);
                int rndnumber2= rndobj.nextInt(5);
                dice1image.setImageResource(diceimages[rndnumber1]);
                dice2image.setImageResource(diceimages[rndnumber2]);

                //adding animation using external dependencies
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(dice1image);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(dice2image);

                mp.start();
            }
        });



    }
}