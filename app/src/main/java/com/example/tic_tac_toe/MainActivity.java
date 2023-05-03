package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=1;
    boolean isw=false;
    int im_click=-1;


    int [][]winingstates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gamestate={-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void reset (View view){
        GridLayout gridLayout=findViewById(R.id.g);
        int t=gridLayout.getChildCount();

        for(int i=0;i<t;i++){
            ImageView v=(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);

        }
        player=1;
        isw=false;
        im_click=-1;
        for(int i=0;i<gamestate.length;i++){
              gamestate[i]=-1;

        }



    }




    public void load (View view){
        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        im_click=gamestate[tag];
        if (isw==false && im_click==-1) {


            if (player == 1) {
                v.setImageResource(R.drawable.x);
                gamestate[tag] = player;
                //Toast.makeText(this, tag + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.o);
                gamestate[tag] = player;
               // Toast.makeText(this, tag + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;

            }
            for (int i = 0; i < winingstates.length; i++) {
                if (gamestate[winingstates[i][0]] == gamestate[winingstates[i][1]] && gamestate[winingstates[i][1]] == gamestate[winingstates[i][2]] && gamestate[winingstates[i][0]] > -1) {
                    Toast.makeText(this, "Winner is Player  " + (player == 0 ? 1 : 2), Toast.LENGTH_SHORT).show();
                    isw=true;
                }



            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}