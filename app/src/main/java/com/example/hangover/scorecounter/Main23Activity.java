package com.example.hangover.scorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class Main23Activity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.example.hangover.scorecounter.MESSAGE";
    String message;
    int p=0;
    int x=0;
    int y=0;
    int z=0;
    int w=0,i=0,j=0,k=0,l=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);
        Intent intent = getIntent();
    }

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
    public void setcomplete(View view){
        if(z==0&&w==0){
            z=x;
            w=y;
            display2(z);
            display3(w);
            x=0;
            y=0;
            display(x);
            display1(y);
        }
        else if(i==0&&j==0){
            i=x;
            j=y;
            display4(i);
            display5(j);
            x=0;
            y=0;
            display(x);
            display1(y);
        }
        else if(k==0&&l==0){
            k=x;
            l=y;
            display6(k);
            display7(l);
            x=0;
            y=0;
            display(x);
            display1(y);
        }
    }
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
    private void display2(int number) {
        TextView set1TextView = (TextView) findViewById(
                R.id.set1_text_view);
        set1TextView.setText("" + number);
    }
    private void display3(int number) {
        TextView set12TextView = (TextView) findViewById(
                R.id.set12_text_view);
        set12TextView.setText("" + number);
    }
    private void display4(int number) {
        TextView set2TextView = (TextView) findViewById(
                R.id.set2_text_view);
        set2TextView.setText("" + number);
    }
    private void display5(int number) {
        TextView set21TextView = (TextView) findViewById(
                R.id.set21_text_view);
        set21TextView.setText("" + number);
    }
    private void display6(int number) {
        TextView set3TextView = (TextView) findViewById(
                R.id.set3_text_view);
        set3TextView.setText("" + number);
    }
    private void display7(int number) {
        TextView set31TextView = (TextView) findViewById(
                R.id.set31_text_view);
        set31TextView.setText("" + number);
    }
    public void reset(View view){
        x=0;
        y=0;
        z=0;
        w=0;
        i=0;
        j=0;
        k=0;
        l=0;
        display(x);
        display1(y);
        display2(z);
        display3(w);
        display4(i);
        display5(j);
        display6(k);
        display7(l);
    }
    public void result(View view){
        Intent intent = new Intent(this, Main27Activity.class);
        if(z>w){
            p+=1;
           // message = "TEAM A WINS!";
        }
        else if(z<w){
            p-=1;
           // message = "TEAM B WINS!";
        }
        if(i>j)
            p+=1;
        else if(i<j)
            p-=1;
        if(k>l)
            p+=1;
        else if(k<l)
            p-=1;
        if(p>0)
            message = "TEAM A WINS!";
        else if(p<0)
            message = "TEAM B WINS!";
        else
            message = "MATCH DRAW!";
        x=0;
        y=0;
        z=0;
        w=0;
        i=0;
        j=0;
        k=0;
        l=0;
        p=0;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    /**
     * This method is called when the order button is clicked.
     */
    /*public void submitOrder(View view) {
        display(1);
    }*/

    /**
     * This method displays the given quantity value on the screen.
     */
   /* private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }*/
}
