package com.tobyrodinroman.onyxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator1 extends AppCompatActivity {

    TextView tvInput, tvOutput;
    float firstNum, total;
    String operator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator1);
        getSupportActionBar().hide();

        tvInput = findViewById(R.id.tv_input);
        tvOutput = findViewById(R.id.tv_output);

    }
    public void onNumberClick(View view){
        switch (view.getId()){

            case R.id.btn0:
                onInputNumbers(0);
                break;
            case R.id.btn1:
                onInputNumbers(1);
                break;
            case R.id.btn2:
                onInputNumbers(2);
                break;
            case R.id.btn3:
                onInputNumbers(3);
                break;
            case R.id.btn4:
                onInputNumbers(4);
                break;
            case R.id.btn5:
                onInputNumbers(5);
                break;
            case R.id.btn6:
                onInputNumbers(6);
                break;
            case R.id.btn7:
                onInputNumbers(7);
                break;
            case R.id.btn8:
                onInputNumbers(8);
                break;
            case R.id.btn9:
                onInputNumbers(9);
                break;

            case R.id.btn_add:
                onInputOperator("add");
                break;
            case R.id.btn_diff:
                onInputOperator("diff");
                break;
            case R.id.btn_prod:
                onInputOperator("prod");
                break;
            case R.id.btn_quo:
                onInputOperator("quo");
                break;
            case R.id.btn_percent:
                onInputOperator("percent");
                break;

            case R.id.btn_dot:
                onInputOperator("dot");
                break;


            case R.id.btn_equal:

                break;
        }
    }
    public void onInputNumbers(int num){
        String currentText = tvInput.getText().toString();
        String newCurrentText = currentText + num;
        tvInput.setText(newCurrentText);

    }
    public void onInputOperator(String operate){
        switch (operate){
            case "add":
                tvInput.setText("+");
                if(tvInput.getText() == "+"){
                    errorMessage();
                }
                break;
            case "diff":
                tvInput.setText("–");
                if(tvInput.getText() == "–"){
                    errorMessage();
                }
                break;
            case "prod":
                tvInput.setText("×");
                if(tvInput.getText() == "×"){
                    errorMessage();
                }
                break;
            case "quo":
                tvInput.setText("÷");
                if(tvInput.getText() == "÷"){
                    errorMessage();
                }
                break;
            case "percent":
                tvInput.setText("%");
                if(tvInput.getText() == "%"){
                    errorMessage();
                }
                break;
            case "dot":
                tvInput.setText(".");
                break;
        }
    }
    public void errorMessage(){
        tvOutput.setText("Error");
    }

    public void allClear(View view){
        tvInput.setText("");
        tvOutput.setText("");
    }
    public void clear(View view){
            String display = tvInput.getText().toString();
            if(display.equals("")) {
                tvInput.setText("");
            }
            else{
                display = display.substring(0, display.length() - 1);
                tvInput.setText(display);
                tvOutput.setText("");

            }
    }
//    public void userNumberInput() {
//        userInput = Float.parseFloat(tvInput.getText().toString());
//        String[] operators = tvInput.getText().toString().split("[1234567890]") ;
//        for (String numbers : inputNumbers) {
//            tvOutput.setText(tvOutput.getText()+numbers);
//        }
//        for (int x = 0; x < inputNumbers.length; x++) {
//
//        }
//    }


}