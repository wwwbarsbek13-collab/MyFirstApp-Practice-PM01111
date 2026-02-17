package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalcActivity extends AppCompatActivity {

    private EditText editTextFirst;
    private EditText editTextSecond;
    private TextView textViewResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        // Инициализация элементов с проверкой на null
        try {
            editTextFirst = findViewById(R.id.editTextFirst);
            editTextSecond = findViewById(R.id.editTextSecond);
            textViewResult = findViewById(R.id.textViewResult);
            btnCalculate = findViewById(R.id.btnCalculate);

            // Проверка, что все элементы найдены
            if (editTextFirst == null || editTextSecond == null ||
                    textViewResult == null || btnCalculate == null) {
                return;
            }

            btnCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateSum();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateSum() {
        try {
            String firstStr = editTextFirst.getText().toString().trim();
            String secondStr = editTextSecond.getText().toString().trim();

            if (firstStr.isEmpty() || secondStr.isEmpty()) {
                textViewResult.setText("Заполните оба поля");
                return;
            }

            double first = Double.parseDouble(firstStr);
            double second = Double.parseDouble(secondStr);
            double result = first + second;

            // Форматирование результата
            if (result == (long) result) {
                textViewResult.setText("Результат: " + (long) result);
            } else {
                textViewResult.setText("Результат: " + result);
            }

        } catch (NumberFormatException e) {
            textViewResult.setText("Ошибка: введите числа");
        } catch (Exception e) {
            textViewResult.setText("Произошла ошибка");
        }
    }
}