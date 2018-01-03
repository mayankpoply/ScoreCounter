package com.example.hangover.scorecounter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
import android.widget.Button;
import android.os.SystemClock;
import android.os.Handler;

/**
 * This app displays an order form to order coffee.
 */
public class Main22Activity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.example.hangover.scorecounter.MESSAGE";
    String message;
    int x=0;
    int y=0;
    public TextView textTimer;
    public Button startButton;
    public Button pauseButton;
    public Button resetButton;
    public long startTime = 0L;
    public Handler myHandler = new Handler();
    long timeInMillies = 0L;
    long timeSwap = 0L;
    long finalTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        Intent intent = getIntent();
        textTimer = (TextView) findViewById(R.id.textTimer);

        startButton = (Button) findViewById(R.id.btnStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                myHandler.postDelayed(updateTimerMethod, 0);

            }
        });

        pauseButton = (Button) findViewById(R.id.btnPause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                timeSwap += timeInMillies;
                myHandler.removeCallbacks(updateTimerMethod);

            }
        });
        resetButton = (Button) findViewById(R.id.btnReset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                x = 0;
                y = 0;
                display(x);
                display1(y);
                startTime = 0;
                timeSwap = 0;
                timeInMillies = 0;
                finalTime = 0;
                //  myHandler.postDelayed(updateTimerMethod, 0);
                myHandler.removeCallbacks(updateTimerMethod);
                textTimer.setText("00" + ":"
                        + String.format("00") + ":"
                        + String.format("000"));

            }
        });

    }
    public Runnable updateTimerMethod = new Runnable() {

        public void run() {
            timeInMillies = SystemClock.uptimeMillis() - startTime;
            finalTime = timeSwap + timeInMillies;

            int seconds = (int) (finalTime / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            int milliseconds = (int) (finalTime % 1000);
            textTimer.setText("" + minutes + ":"
                    + String.format("%02d", seconds) + ":"
                    + String.format("%03d", milliseconds));
            myHandler.postDelayed(this, 0);
        }

    };

    /**
     * This method is called when the order button is clicked.
     */
    public void points3(View view) {
        x+=1;
        display(x);
        //   displayPrice(x*y);
    }
    public void points31(View view){
        y+=1;
        display1(y);
        //  displayPrice(x*y);
    }
    public void result(View view){
        Intent intent = new Intent(this, Main26Activity.class);
        if(x>y){
            message = "TEAM A WINS!";
        }
        else if(y>x){
            message = "TEAM B WINS!";
        }
        else
            message = "MATCH DRAW!";
        x=0;
        y=0;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    /*public void points2(View view) {
        x+=2;
        display(x);
        //   displayPrice(x*y);
    }
    public void points21(View view) {
        y+=2;
        display1(y);
        //   displayPrice(x*y);
    }
    public void freethrow(View view) {
        x+=1;
        display(x);
        //   displayPrice(x*y);
    }
    public void freethrow1(View view) {
        y+=1;
        display1(y);
        //   displayPrice(x*y);
    }*/

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView teamATextView = (TextView) findViewById(
                R.id.teamA_text_view);
        teamATextView.setText("" + number);
    }
    private void display1(int number) {
        TextView teamBTextView = (TextView) findViewById(
                R.id.teamB_text_view);
        teamBTextView.setText("" + number);
    }
   /* private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/
}