package com.example.poota.jeuadeux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    int j1Counter;
    int j2Counter;

    Button j1Button;
    Button j2Button;
    Button resetButton;

    TextView textJ1;
    TextView textJ2;
    boolean finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //initialisation
        j1Button = (Button) findViewById(R.id.j1_button);
        j2Button = (Button) findViewById(R.id.j2_button);
        resetButton = (Button) findViewById(R.id.reset_button);

        textJ1 =  (TextView) findViewById(R.id.j1_score_tv);
        textJ2 =  (TextView) findViewById(R.id.j2_score_tv);

        j1Button.setOnClickListener(this);
        j2Button.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        reset();
    }

    public int actionJ(String name, int counter, TextView textView) {
        if (!finished) {
            counter++;
            textView.setText("le score est de: " + counter);

            if (counter == 10) {
                finished = true;
                Toast.makeText(GameActivity.this, name+" gagne!", Toast.LENGTH_LONG).show();
            }
        }

        return counter;
    }

    public void reset() {
        j1Counter = 0;
        j2Counter = 0;
        finished = false;

        textJ1.setText("le score est de: " + j1Counter);
        textJ2.setText("le score est de: " + j2Counter);

        Toast.makeText(this, "Commencez!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.j1_button:
                j1Counter = actionJ("Joueur1", j1Counter, textJ1);
                break;
            case R.id.j2_button:
                j2Counter = actionJ("Joueur2", j2Counter, textJ2);
                break;
            case R.id.reset_button:
                reset();
                break;
        }
    }
}