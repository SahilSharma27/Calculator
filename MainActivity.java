package com.example.android.realcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    TextView textView;
    String s="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        Button one=findViewById(R.id.one);
        Button two=findViewById(R.id.two);
        Button three=findViewById(R.id.three);
        Button four=findViewById(R.id.four);
        Button five=findViewById(R.id.five);
        Button six=findViewById(R.id.six);
        Button seven=findViewById(R.id.seven);
        Button eight=findViewById(R.id.eight);
        Button nine=findViewById(R.id.nine);
        Button zero=findViewById(R.id.zero);
        Button decimal=findViewById(R.id.decimal);
        Button clear=findViewById(R.id.c);
        Button add=findViewById(R.id.add);
        Button subtract=findViewById(R.id.subtract);
        Button product=findViewById(R.id.product);
        Button divide=findViewById(R.id.divide);
        Button equal=findViewById(R.id.equal);
        one.setOnClickListener(toPerform);
        two.setOnClickListener(toPerform);
        three.setOnClickListener(toPerform);
        four.setOnClickListener(toPerform);
        five.setOnClickListener(toPerform);
        six.setOnClickListener(toPerform);
        seven.setOnClickListener(toPerform);
        eight.setOnClickListener(toPerform);
        nine.setOnClickListener(toPerform);
        zero.setOnClickListener(toPerform);
        decimal.setOnClickListener(toPerform);
        add.setOnClickListener(toPerform);
        subtract.setOnClickListener(toPerform);
        product.setOnClickListener(toPerform);
        divide.setOnClickListener(toPerform);
        clear.setOnClickListener(toPerform);
        equal.setOnClickListener(toPerform);
        clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textView.setText("0");
                s="0";
                return true;
            }
        });




    }


    View.OnClickListener toPerform=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.one: s+="1";
                                break;
                case R.id.two: s+="2";
                    break;
                case R.id.three: s+="3";
                    break;
                case R.id.four: s+="4";
                    break;
                case R.id.five: s+="5";
                    break;
                case R.id.six: s+="6";
                    break;
                case R.id.seven: s+="7";
                    break;
                case R.id.eight: s+="8";
                    break;
                case R.id.nine: s+="9";
                    break;
                case R.id.zero: s+="0";
                    break;
                case R.id.decimal: s+=".";
                    break;
                case R.id.equal: calculate();
                    break;
                case R.id.c: s=s.substring(0,s.length()-1);
                    break;
                case R.id.add: s+="+";
                    break;
                case R.id.subtract: s+="-";
                    break;
                case R.id.product: s+="x";
                    break;
                case R.id.divide: s+="/";
                    break;



            }
            textView.setText(s.substring(1));

        }
    };
        void calculate(){
            double ans=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='x'||s.charAt(i)=='/'){
                    char op=s.charAt(i);
                    double num1=Double.parseDouble(s.substring(1,i));
                    double num2=Double.parseDouble(s.substring(i+1));
                   // Toast.makeText(this,Character.toString(op),Toast.LENGTH_LONG).show();
                    switch(op){
                        case '+': ans=num1+num2;
                        break;
                        case '-': ans=num1-num2;
                        break;
                        case 'x':ans=num1*num2;
                        break;
                        case '/':ans=num1/num2;
                    }

                    s="0"+Double.toString(ans);
                }
            }
        }


    }

