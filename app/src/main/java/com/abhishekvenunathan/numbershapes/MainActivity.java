package com.abhishekvenunathan.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String message;

    class Number{

        int number;

        public boolean isSquare(){

            double squareRoot = Math.sqrt(number);

            if(squareRoot == Math.floor(squareRoot)) { return true;}
            else {return false;}


        }

        public boolean isTriangular(){

            int x=1;
            int triangularNumber = 1;
            while(triangularNumber < number){
                x++;
                triangularNumber+=x;

            }

            if (triangularNumber == number) {return true;}
            else {return false;}

        }

    }

    public void checkNumber(View view) {
        Number myNumber = new Number();
        EditText userNumber = findViewById(R.id.editText);
        if (TextUtils.isEmpty(userNumber.getText())) {
            userNumber.setError("Enter a valid number");
        } else {
            myNumber.number = Integer.parseInt(userNumber.getText().toString());


            if (myNumber.isSquare()) {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is a square number and a triangular number!";
                } else {
                    message = myNumber.number + " is a square number but not a triangular number!";
                }
            } else if (myNumber.isTriangular()) {
                message = myNumber.number + " is a triangular number but not a square number!";
            } else {
                message = myNumber.number + " is not a square number or a triangular number!";
            }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
