package com.example.henne.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

import static java.lang.Math.round;

// Fonctionne avec Nexus 4

public class MainActivity extends Activity {
    public char operator = 'r';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chiffres
        Button b0 = (Button)findViewById(R.id.button0);
        b0.setOnClickListener(clickListenerBoutons);

        Button b1 = (Button)findViewById(R.id.button1);
        b1.setOnClickListener(clickListenerBoutons);

        Button b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(clickListenerBoutons);

        Button b3 = (Button)findViewById(R.id.button3);
        b3.setOnClickListener(clickListenerBoutons);

        Button b4 = (Button)findViewById(R.id.button4);
        b4.setOnClickListener(clickListenerBoutons);

        Button b5 = (Button)findViewById(R.id.button5);
        b5.setOnClickListener(clickListenerBoutons);

        Button b6 = (Button)findViewById(R.id.button6);
        b6.setOnClickListener(clickListenerBoutons);

        Button b7 = (Button)findViewById(R.id.button7);
        b7.setOnClickListener(clickListenerBoutons);

        Button b8 = (Button)findViewById(R.id.button8);
        b8.setOnClickListener(clickListenerBoutons);

        Button b9 = (Button)findViewById(R.id.button9);
        b9.setOnClickListener(clickListenerBoutons);


        // Operateurs
        Button bplus = (Button)findViewById(R.id.button_plus);
        bplus.setOnClickListener(clickListernerOperator);

        Button bmoins = (Button)findViewById(R.id.button_moins);
        bmoins.setOnClickListener(clickListernerOperator);

        Button bfois = (Button)findViewById(R.id.button_fois);
        bfois.setOnClickListener(clickListernerOperator);

        Button bdivise = (Button)findViewById(R.id.button_divise);
        bdivise.setOnClickListener(clickListernerOperator);

        // Egal et Cancel
        Button begal = (Button)findViewById(R.id.button_egal);
        begal.setOnClickListener(clickListenerEnd);

        Button bcancel = (Button)findViewById(R.id.button_cancel);
        bcancel.setOnClickListener(clickListenerEnd);

    }

    private View.OnClickListener clickListenerEnd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isEgal;
            switch (v.getId()) {
                case R.id.button_egal:
                    isEgal = true;
                    break;
                case R.id.button_cancel:
                    isEgal = false;
                    break;
                default:
                    isEgal = true;
                    break;
            }
            TextView text = (TextView)findViewById(R.id.id_textView);

            if (isEgal && operator != 'r') {
                double result = 0;
                String[] tabResult = text.getText().toString().split(Pattern.quote(String.valueOf(operator)));

                switch (operator) {
                    case '+':
                        result = Double.parseDouble(tabResult[0]) + Double.parseDouble(tabResult[1]);
                        break;
                    case '-':
                        result = Double.parseDouble(tabResult[0]) - Double.parseDouble(tabResult[1]);
                        break;
                    case '*':
                        result = Double.parseDouble(tabResult[0]) * Double.parseDouble(tabResult[1]);
                        break;
                    case '/':
                        result = round((Double.parseDouble(tabResult[0]) / Double.parseDouble(tabResult[1]))*1000.0) / 1000.0;
                        break;
                    default:
                        result = 0;
                        break;
                }
                text.setText("" + result);
            } else if (!isEgal){
                text.setText("0");
                operator = 'r';
            }
        }
    };

    private View.OnClickListener clickListernerOperator = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            char signe;
            switch (v.getId()) {
                case R.id.button_plus:
                    signe = '+';
                    break;
                case R.id.button_moins:
                    signe = '-';
                    break;
                case R.id.button_fois:
                    signe = '*';
                    break;
                case R.id.button_divise:
                    signe = '/';
                    break;
                default:
                    signe = '+';
                    break;
            }
            operator = signe;

            TextView text = (TextView)findViewById(R.id.id_textView);
            if (!text.getText().equals("0")) {
                text.setText("" + text.getText() + signe);
            } else {
                text.setText("" + signe);
            }
        }
    };

    private View.OnClickListener clickListenerBoutons = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int number;
            switch (v.getId()) {
                case R.id.button0:
                    number = 0;
                    break;
                case R.id.button1:
                    number = 1;
                    break;
                case R.id.button2:
                    number = 2;
                    break;
                case R.id.button3:
                    number = 3;
                    break;
                case R.id.button4:
                    number = 4;
                    break;
                case R.id.button5:
                    number = 5;
                    break;
                case R.id.button6:
                    number = 6;
                    break;
                case R.id.button7:
                    number = 7;
                    break;
                case R.id.button8:
                    number = 8;
                    break;
                case R.id.button9:
                    number = 9;
                    break;
                default:
                    number = 0;
                    break;
            }
            TextView text = (TextView)findViewById(R.id.id_textView);

            if (!text.getText().toString().equals("0")) {
                text.setText("" + text.getText() + number);
            } else {
                text.setText("" + number);
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
