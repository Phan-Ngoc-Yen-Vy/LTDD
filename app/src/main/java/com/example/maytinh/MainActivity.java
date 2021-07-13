package com.example.maytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView chu;
    private TextView cha;
    private TextView ch;
    private TextView matngoai;
    private EditText edtso;
    private String input, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chu = (TextView) findViewById(R.id.chu);
        cha = (TextView) findViewById(R.id.cha);
        ch = (TextView) findViewById(R.id.ch);
        matngoai = (TextView) findViewById(R.id.matngoai);
        edtso = (EditText) findViewById(R.id.edtso);
    }

    public void ButtonClink(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data) {
            case "ON/C":
                if(input.length()>0) {
                    String newText = input.substring(0, input.length()-1);
                    input = newText;
                }
                break;
            case "=":
                Solve();
                answer = input;
                break;
            case "X":
                Solve();
                input += "*";
                break;
            case "÷":
                Solve();
                input += "/";
                break;
            default:
                if(input==null) {
                    input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")) {
                    Solve();
                    // in ket qua
                }
                input += data;
        }
        chu.setText(input);
        cha.setText(input);
        ch.setText(input);
        matngoai.setText(input);
        edtso.setText(input);
    }
    public void Solve() {
        if(input.split("\\*").length==2) {
            String number[] = input.split("\\*");
            try{
                double mul = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input = mul+"";
            }catch (Exception e) {

            }
        }
        if(input.split("\\/").length==2) {
            String number[] = input.split("\\/");
            try{
                double div = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input = div+"";
            }catch (Exception e) {

            }
        }
        if(input.split("\\+").length==2) {
            String number[] = input.split("\\+");
            try{
                double sum = Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input = sum+"";
            }catch (Exception e) {

            }
        }
        if(input.split("\\-").length==2) {
            String number[] = input.split("\\-");
            try{
                double sub = Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input = sub+"";
            }catch (Exception e) {

            }
        }
    }
}


