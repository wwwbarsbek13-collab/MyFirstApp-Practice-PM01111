package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Находим кнопку "Назад"
        Button btnBack = findViewById(R.id.btnBack);

        // Устанавливаем обработчик для закрытия активности
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрывает текущую Activity и возвращает на предыдущую
            }
        });
    }
}