package com.example.calcula;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
        Button bt3 = findViewById(R.id.bt3);
        Button bt4 = findViewById(R.id.bt4);

        bt1.setOnClickListener(x -> Calculate('+'));
        bt2.setOnClickListener(x -> Calculate('-'));
        bt3.setOnClickListener(x -> Calculate('*'));
        bt4.setOnClickListener(x -> Calculate(':'));

    }
    public void Calculate(char operation)
    {
        TextView Result = findViewById(R.id.result);
        EditText et1 = findViewById(R.id.et1);
        EditText et2 = findViewById(R.id.et2);

        try {

            double num1 = Double.parseDouble(et1.getText().toString().trim().replace(',','.'));
            double num2 = Double.parseDouble(et2.getText().toString().trim().replace(',','.'));
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,
                    "Видимо, где-то буквенное выражение?",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        try
        {
            double num1 = Double.parseDouble(et1.getText().toString().trim().replace(',','.'));
            double num2 = Double.parseDouble(et2.getText().toString().trim().replace(',','.'));
            double num3 = 0;

            if(operation == '+')
            {
                num3 = num1 + num2;
            }
            else if(operation == '-')
            {
                num3 = num1 - num2;
            }
            else if(operation == '*')
            {
                num3 = num1 * num2;
            }
            else if(operation == ':')
            {
                if(num2 == 0)
                {
                    Toast.makeText(MainActivity.this, "Нельзя делить на 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                num3 = num1 / num2;
            }
            Result.setText(String.valueOf(num3));
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,
                    "Какая-то ошибка",
                    Toast.LENGTH_SHORT).show();
            return;
        }
    }
}