package com.tobyrodinroman.onyxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Calculator1 extends AppCompatActivity {

    private static boolean startUpMethod = true;

    TextView tvInput, tvOutput;
    String firstNum, secondNum, inputNumbers, operator;
    float semiGrandTotal;
    float grandTotal;
    float percentTotal;
    float total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(startUpMethod){
                firstNum = "";
        }
        startUpMethod = false;

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
        if(total == 0.0){
            firstNum = currentText + num;
            tvInput.setText(firstNum);
        }else{
            secondNum = currentText + num;
            tvInput.setText(secondNum);
        }

        if(operator == "add"){
            String[] splittedString = secondNum.split("[+]");
            String inputNumbers = splittedString[splittedString.length-1];
            semiGrandTotal = total + Float.parseFloat(inputNumbers);
            tvOutput.setText(semiGrandTotal+"");
        }else if(operator == "diff"){
            String[] splittedString = secondNum.split("[–]");
            String inputNumbers = splittedString[splittedString.length-1];
            semiGrandTotal = total - Float.parseFloat(inputNumbers);
            tvOutput.setText(semiGrandTotal+"");
        }else if(operator == "prod"){
            String[] splittedString = secondNum.split("[×]");
            String inputNumbers = splittedString[splittedString.length-1];
            semiGrandTotal = total * Float.parseFloat(inputNumbers);
            tvOutput.setText(semiGrandTotal+"");
        }else if(operator == "quo"){
            String[] splittedString = secondNum.split("[÷]");
            String inputNumbers = splittedString[splittedString.length-1];
            semiGrandTotal = total / Float.parseFloat(inputNumbers);
            tvOutput.setText(semiGrandTotal+"");
        }

    }
    public void onInputOperator(String operate){
        String currentInputDisplay = firstNum;

        switch (operate) {
            case "add":
                operator = "add";
                tvInput.setText(currentInputDisplay + "+");
                if(semiGrandTotal != 0.0){
                    tvInput.setText(secondNum + "+");
                    total = semiGrandTotal;
                }else if (currentInputDisplay == "" && operate == "add") {
                    errorMessage();
                }else{
                    total = Float.parseFloat(currentInputDisplay);
                    tvOutput.setText(total+"");
                }
                break;
            case "diff":
                operator = "diff";
                tvInput.setText(currentInputDisplay + "–");
                if(semiGrandTotal != 0.0){
                    tvInput.setText(secondNum + "–");
                    total = semiGrandTotal;
                }else if (currentInputDisplay == "" && operate == "diff") {
                    errorMessage();
                }else{
                    total = Float.parseFloat(currentInputDisplay);
                    tvOutput.setText(total+"");
                }
                break;
            case "prod":
                operator = "prod";
                tvInput.setText(currentInputDisplay + "×");
                if(semiGrandTotal != 0.0){
                    tvInput.setText(secondNum + "×");
                    total = semiGrandTotal;
                }else if (currentInputDisplay == "" && operate == "prod") {
                    errorMessage();
                }else{
                    total = Float.parseFloat(currentInputDisplay);
                    tvOutput.setText(total+"");
                }
                break;
            case "quo":
                operator = "quo";
                tvInput.setText(currentInputDisplay + "÷");
                if(semiGrandTotal != 0.0){
                    tvInput.setText(secondNum + "÷");
                    total = semiGrandTotal;
                }else if (currentInputDisplay == "" && operate == "quo") {
                    errorMessage();
                }else{
                    total = Float.parseFloat(currentInputDisplay);
                    tvOutput.setText(total+"");
                }
                break;
            case "percent":
                tvInput.setText(currentInputDisplay + "%");
                if (currentInputDisplay == "" && operate == "percent") {
                    errorMessage();

                }else{
                    tvInput.setText(currentInputDisplay + "%");
                    percentTotal = Float.parseFloat(currentInputDisplay)/100;
                    tvOutput.setText(""+ percentTotal);
                }
                break;
            case "dot":
                tvInput.setText(currentInputDisplay + ".");
                break;
        }
        firstNum = "";
    }
    public void errorMessage(){
        tvOutput.setText("Error");
    }

    public void allClear(View view){
        tvInput.setText("");
        tvOutput.setText("");
        firstNum = "";
        total = 0;
        inputNumbers = "";
        operator = null;
        secondNum = "";
        semiGrandTotal = 0;

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
//        String[] inputNumbers = tvInput.getText().toString().split("[%+-x÷]") ;
//        String[] operators = tvInput.getText().toString().split("[1234567890]") ;
//        for (String numbers : inputNumbers) {
//            tvOutput.setText(tvOutput.getText()+numbers);
//        }
//        for (int x = 0; x < inputNumbers.length; x++) {
//
//        }
//    }


}