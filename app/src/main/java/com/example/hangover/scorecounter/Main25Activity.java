package com.example.hangover.scorecounter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

//import com.example.hangover.scorecounter.R;

/**
 * This app displays an order form to order coffee.
 */
public class Main25Activity extends ActionBarActivity {
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main25);
        Intent intent = getIntent();
        message = intent.getStringExtra(Main2Activity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        // Set the text view as the activity layout
        setContentView(textView);
    }
  /*  public void openit(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void openit1(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Main22Activity.class);
        startActivity(intent);
    }
    public void openit2(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Main23Activity.class);
        startActivity(intent);
    }

    public void openit3(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Main24Activity.class);
        startActivity(intent);
    }


    /**
     * This method is called when the order button is clicked.
     */
   /* public void submitOrder(View view) {
        display(1);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
   /* private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }*/
}