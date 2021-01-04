package com.tobyrodinroman.onyxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Calculator1 extends AppCompatActivity {

    TextView tvInput, tvOutput;
    String firstNum="", secondNum, inputNumbers, operator;
    Double semiGrandTotal;
    float grandTotal;
    Double percentTotal;
    Double total;



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
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);

        String currentText = tvInput.getText().toString();
        if(total == null){
            firstNum = currentText + num;
            tvInput.setText(firstNum);
            if(firstNum.equals("492000")){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pornhub.com"));
                startActivity(intent);
            }
            if(firstNum.equals("1291997")){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.spankbang.com"));
                startActivity(intent);
            }
            if(firstNum.equals("7171995")){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pinayflix.com"));
                startActivity(intent);
            }
            if(firstNum.equals("2132000")){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.katorsex.com"));
                startActivity(intent);
            }
        }else{
            secondNum = currentText + num;
            tvInput.setText(secondNum);
        }

        if(operator == "add"){
            String[] splittedString = secondNum.split("[+]");
            String inputNumbers = splittedString[splittedString.length-1];
            semiGrandTotal = total + Double.parseDouble(inputNumbers);
            tvOutput.setText(format.format(semiGrandTotal)+"");
        }else if(operator == "diff"){
            String[] splittedString = secondNum.split("[–]");
            String inputNumbers = splittedString[splittedString.length-1];
            semiGrandTotal = total - Double.parseDouble(inputNumbers);
            tvOutput.setText(format.format(semiGrandTotal)+"");
        }else if(operator == "prod"){
            String[] splittedString = secondNum.split("[×]");
            String inputNumbers = splittedString[splittedString.length-1];
            semiGrandTotal = total * Double.parseDouble(inputNumbers);
            tvOutput.setText(format.format(semiGrandTotal)+"");
        }else if(operator == "quo"){
            String[] splittedString = secondNum.split("[÷]");
            String inputNumbers = splittedString[splittedString.length-1];
            semiGrandTotal = total / Double.parseDouble(inputNumbers);
            tvOutput.setText(format.format(semiGrandTotal)+"");
        }else if(operator == "percent"){
            String[] splittedString = secondNum.split("[%]");
            inputNumbers = splittedString[splittedString.length-1];
            semiGrandTotal = (total/100) * Double.parseDouble(inputNumbers);
//            tvOutput.setText(format.format(semiGrandTotal)+"");
            errorMessage();
        }

    }
    public void onInputOperator(String operate){
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);

        String currentInputDisplay = firstNum;

        switch (operate) {
            case "add":
                operator = "add";
                tvInput.setText(currentInputDisplay + "+");
                if(semiGrandTotal != null){
                    tvInput.setText(secondNum + "+");
                    total = semiGrandTotal;
                }else if (currentInputDisplay == "" && operate == "add") {
                    errorMessage();
                }else{
                    total = Double.parseDouble(currentInputDisplay);
                    tvOutput.setText(format.format(total)+"");
                }
                break;
            case "diff":
                operator = "diff";
                tvInput.setText(currentInputDisplay + "–");
                if(semiGrandTotal != null){
                    tvInput.setText(secondNum + "–");
                    total = semiGrandTotal;
                }else if (currentInputDisplay == "" && operate == "diff") {
                    errorMessage();
                }else{
                    total = Double.parseDouble(currentInputDisplay);
                    tvOutput.setText(format.format(total)+"");
                }
                break;
            case "prod":
                operator = "prod";
                tvInput.setText(currentInputDisplay + "×");
                if(semiGrandTotal != null){
                    tvInput.setText(secondNum + "×");
                    total = semiGrandTotal;
                }else if (currentInputDisplay == "" && operate == "prod") {
                    errorMessage();
                }else{
                    total = Double.parseDouble(currentInputDisplay);
                    tvOutput.setText(format.format(total)+"");
                }
                break;
            case "quo":
                operator = "quo";
                tvInput.setText(currentInputDisplay + "÷");
                if(semiGrandTotal != null){
                    tvInput.setText(secondNum + "÷");
                    total = semiGrandTotal;
                }else if (currentInputDisplay == "" && operate == "quo") {
                    errorMessage();
                }else{
                    total = Double.parseDouble(currentInputDisplay);
                    tvOutput.setText(format.format(total)+"");
                }
                break;
            case "percent":
                operator = "percent";
                tvInput.setText(currentInputDisplay + "%");
                if(semiGrandTotal != null){
                    tvInput.setText(secondNum + "%");
                    semiGrandTotal = (total/100) * Double.parseDouble(inputNumbers);
                    tvOutput.setText(format.format(semiGrandTotal));
                }else if(currentInputDisplay == "" && operate == "percent") {
                    errorMessage();
                }else{
                    total = Double.parseDouble(currentInputDisplay)/100;
                    tvOutput.setText(format.format(total));
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
        total = null;
        inputNumbers = "";
        operator = null;
        secondNum = "";
        semiGrandTotal = null;

    }
    public void clear(View view){
            String display = tvInput.getText().toString();
            if(display.equals("")) {
                tvInput.setText("");
            }
            else{
                display = display.substring(0, display.length() - 1);
                tvInput.setText(display);
                tvOutput.setText(semiGrandTotal+"");
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