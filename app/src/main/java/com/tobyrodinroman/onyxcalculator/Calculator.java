package com.tobyrodinroman.onyxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {


    TextView tvInput, tvOutput;
    float firstNum, secondNum, result;
    String operation;
//    String[] deLimiter = tvInput.getText().toString().split("%") ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().hide();

        tvInput = findViewById(R.id.tv_input);
        tvOutput = findViewById(R.id.tv_output);

    }

    public void updateInputText(String inputs){
        String currentText = tvInput.getText().toString();
        tvInput.setText(currentText + inputs);
    }

    public void btnOne(View view){
        updateInputText("1");
    }
    public void btnTwo(View view){
        updateInputText("2");
    }
    public void btnThree(View view){
        updateInputText("3");
    }
    public void btnFour(View view){
        updateInputText("4");
    }
    public void btnFive(View view){
        updateInputText("5");
    }
    public void btnSix(View view){
        updateInputText("6");
    }
    public void btnSeven(View view){
        updateInputText("7");
    }
    public void btnEight(View view){
        updateInputText("8");
    }
    public void btnNine(View view){
        updateInputText("9");
    }
    public void btnZero(View view){
        updateInputText("0");
    }

    public void btnPercent(View view){
        updateInputText("%");
    }
    public void btnDot(View view){
        updateInputText(".");
    }


    public void getFirstNum(){
        firstNum = Float.parseFloat(tvInput.getText().toString());
        String firstInput = Float.toString(firstNum);
        tvOutput.setText(firstInput);
        tvInput.setText(null);
    }
    public void btnDivide(View view){
        operation = "÷";
        getFirstNum();
    }
    public void btnMultiply(View view){
        operation = "×";
        getFirstNum();
    }
    public void btnSubtraction(View view){
        operation = "–";
        getFirstNum();
    }
    public void btnAddition(View view){
        operation = "+";
        getFirstNum();
    }

    public void allClear(View view){
        tvInput.setText(null);
        tvOutput.setText(null);
    }
    public void clear(View view){
        String value = tvInput.getText().toString();
        value = value.substring(0, value.length() - 1);
        tvInput.setText(value);
    }

    public void equal(View view){
        secondNum = Float.parseFloat( tvInput.getText().toString());
       if(operation == "+"){
            result = firstNum + secondNum;
            String answer = Float.toString(result);
            tvOutput.setText(answer);
            tvInput.setText("");
        }
        if(operation == "–"){
            result = firstNum - secondNum;
            String answer = Float.toString(result);
            tvOutput.setText(answer);
            tvInput.setText("");
        }
        if(operation == "×"){
            result = firstNum * secondNum;
            String answer = Float.toString(result);
            tvOutput.setText(answer);
            tvInput.setText("");
        }
        if(operation == "÷"){
            result = firstNum / secondNum;
            String answer = Float.toString(result);
            tvOutput.setText(answer);
            tvInput.setText("");
        }
    }

//    public void onCalculatorClick(View view) {
//
//        switch (view.getId()){
//            case R.id.btn1:
//                inputInteger(1);
//                 break;
//            case R.id.btn2:
//                inputInteger(2);
//                break;
//            case R.id.btn3:
//                inputInteger(3);
//                break;
//            case R.id.btn4:
//                inputInteger(4);
//                break;
//            case R.id.btn5:
//                inputInteger(5);
//                break;
//            case R.id.btn6:
//                inputInteger(6);
//                break;
//            case R.id.btn7:
//                inputInteger(7);
//                break;
//            case R.id.btn8:
//                inputInteger(8);
//                break;
//            case R.id.btn9:
//                inputInteger(9);
//                break;
//            case R.id.btn0:
//                inputInteger(0);
//                break;
//
//
//            case R.id.btn_percent:
//                doOperation("percent");
//                break;
//            case R.id.btn_dot:
//                doOperation("dot");
//                break;
//            case R.id.btn_equal:
//                doOperation("equal");
//                break;
//
//
//            case R.id.btn_add:
//                doOperation("add");
//                break;
//            case R.id.btn_diff:
//                doOperation("diff");
//                break;
//            case R.id.btn_prod:
//                doOperation("prod");
//                break;
//            case R.id.btn_quo:
//                doOperation("quo");
//                break;
//
//
//            case R.id.btn_allClear:
//                clearOutputText();
//                break;
//            case R.id.btn_clear:
//                clear();
//                break;
//            default:
//                break;
//
//        }
//    }
//    public void inputInteger(int value){
//        tvInput.setText(tvInput.getText() + String.valueOf(value));
//    }
//
//    public void clearOutputText(){
//        tvInput.setText("");
//        tvOutput.setText("");
//
//    }
//    public void clear(){
//        String value = tvInput.getText().toString();
//        value = value.substring(0, value.length() - 1);
//        tvInput.setText(value);
//    }
//    public void doOperation(String operation){
//        String currentInputText = tvInput.getText().toString();
//        switch (operation){
//            case "dot":
//                tvInput.setText(currentInputText + ".");
//                break;
//            case "percent":
//                tvInput.setText(currentInputText + "%");
//                break;
//            case "equal":
//                computeOutput();
//                break;
//
//
//            case "add":
//                tvInput.setText(currentInputText + "+");
//                break;
//            case "diff":
//                tvInput.setText(currentInputText + "–");
//                break;
//            case "prod":
//                tvInput.setText(currentInputText + "×");
//                break;
//            case "quo":
//                tvInput.setText(currentInputText + "÷");
//                break;
//        }
//
//    }
//
//    public void computeOutput(){
//        tvOutput.setText("tang ina mo");
//    }
}