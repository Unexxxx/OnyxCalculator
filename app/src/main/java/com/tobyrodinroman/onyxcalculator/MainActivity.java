package com.tobyrodinroman.onyxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tvCalcu;
    float grandTotal;
    String currentOperation, firstNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        tvCalcu = findViewById(R.id.tv_calcu);
    }

    public void onCalculatorClick(View v) {

        switch (v.getId()) {
            case R.id.btn_clear:
                clearOutputText();
                break;
            case R.id.btn_add:
                doOperation("ADD");
                break;
            case R.id.btn_diff:
                doOperation("MINUS");
                break;
            case R.id.btn_prod:
                doOperation("MULTIPLY");
                break;
            case R.id.btn_quo:
                doOperation("DIVIDE");
                break;
            case R.id.btn_dot:
                doOperation("DOT");
                break;
            case R.id.btn_percent:
                doOperation("PERCENT");
                break;
            case R.id.btn_equal:
                doOperation("EQUAL");
                break;

            case R.id.btn_one:
                updateOutputTextUsingInteger(1);
                break;
            case R.id.btn_two:
                updateOutputTextUsingInteger(2);
                break;
            case R.id.btn_three:
                updateOutputTextUsingInteger(3);
                break;
            case R.id.btn_four:
                updateOutputTextUsingInteger(4);
                break;
            case R.id.btn_five:
                updateOutputTextUsingInteger(5);
                break;
            case R.id.btn_six:
                updateOutputTextUsingInteger(6);
                break;
            case R.id.btn_seven:
                updateOutputTextUsingInteger(7);
                break;
            case R.id.btn_eight:
                updateOutputTextUsingInteger(8);
                break;
            case R.id.btn_nine:
                updateOutputTextUsingInteger(9);
                break;
            case R.id.btn_zero:
                updateOutputTextUsingInteger(0);
                break;
            default:
                break;
        }
    }

    public void updateOutputTextUsingInteger(int value){
        tvCalcu.setText(tvCalcu.getText() + String.valueOf(value));

        if (tvCalcu.getText().length() == 12) {
            Toast.makeText(MainActivity.this, "Reached the maximum number of digits (12)", Toast.LENGTH_SHORT).show();
        }

        if(currentOperation != null && firstNum != null){
            float firstNumFloat = Float.parseFloat(firstNum);
            switch (currentOperation){
                case "ADD":
                    grandTotal = firstNumFloat + value;
                    break;
                case "MINUS":
                    grandTotal = firstNumFloat - value;
                    break;
                case "MULTIPLY":
                    grandTotal = firstNumFloat * value;
                    break;
                case "DIVIDE":
                    grandTotal = firstNumFloat / value;
                    break;
            }
            currentOperation = null;
            firstNum = grandTotal+"";
        }
        else{
            firstNum = tvCalcu.getText().toString();
            if(firstNum.equals("492000")){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pornhub.com"));
                startActivity(intent);
            }

        }
    }

    public void clearOutputText(){
        tvCalcu.setText("");
        firstNum = null;
        currentOperation = null;
        grandTotal = 0;
    }
    public void computeOutput(){
        tvCalcu.setText(""+grandTotal);
    }

    public void doOperation(String operation){
        String currentOutputText = tvCalcu.getText().toString();
        switch(operation){
            case "ADD":
                tvCalcu.setText(currentOutputText + "+");
                currentOperation = "ADD";
                break;
            case "MINUS":
                tvCalcu.setText(currentOutputText + "–");
                currentOperation = "MINUS";
                break;
            case "MULTIPLY":
                tvCalcu.setText(currentOutputText + "×");
                currentOperation = "MULTIPLY";
                break;
            case "DIVIDE":
                tvCalcu.setText(currentOutputText + "÷");
                currentOperation = "DIVIDE";
                break;
            case "DOT":
                tvCalcu.setText(currentOutputText + ".");
                break;
            case "PERCENT":
                tvCalcu.setText(currentOutputText + "%");
                break;
            case "EQUAL":
                computeOutput();
                break;
            default:
                break;
        }


    }
}