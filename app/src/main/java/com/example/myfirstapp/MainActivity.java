package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация ListView
        ListView listView = findViewById(R.id.lvScreens);

        // Данные для списка (добавлен "Калькулятор")
        String[] screens = {
                "Главный экран",
                "Профиль",
                "Калькулятор",      // Добавлен новый пункт
                "Настройки",
                "Помощь",
                "О приложении",
                "Контакты",
                "Галерея"
        };

        // Создание адаптера для списка
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                screens
        );

        // Установка адаптера
        listView.setAdapter(adapter);

        // Обработка нажатий на элементы списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                // В зависимости от выбранного элемента открываем соответствующий экран
                switch (position) {
                    case 0: // Главный экран
                        // Уже на главном экране
                        break;
                    case 1: // Профиль
                        Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(profileIntent);
                        break;
                    case 2: // Калькулятор (новый пункт)
                        Intent calcIntent = new Intent(MainActivity.this, CalcActivity.class);
                        startActivity(calcIntent);
                        break;
                    case 3: // Настройки
                        // Здесь можно добавить переход на экран настроек
                        // Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                        // startActivity(settingsIntent);
                        break;
                    case 4: // Помощь
                        // Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
                        // startActivity(helpIntent);
                        break;
                    default:
                        // Для остальных пунктов пока просто показываем тост
                        android.widget.Toast.makeText(MainActivity.this,
                                "Выбран: " + selectedItem,
                                android.widget.Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        // Находим кнопку по ID из XML
        Button btnToProfile = findViewById(R.id.btnToProfile);

        // Устанавливаем обработчик нажатия
        btnToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}