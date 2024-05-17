package com.example.homework;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener {
    public static final int ITEM_ON = 1;
    public static final int ITEM_OFF = 0;
    public EditText inputET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputET = findViewById(R.id.inputET);
        registerForContextMenu(inputET);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, ITEM_ON, Menu.NONE, "Цветовое качество");
        menu.add(Menu.NONE, ITEM_OFF, Menu.NONE, "Выход из приложения");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == ITEM_OFF) {
            finish();
        }
        if (item.getItemId() == ITEM_ON) {
            String result = String.valueOf(inputET.getText());
            if (result.equals("1")) {
                inputET.setBackgroundColor(Color.CYAN);
            } else if (result.equals("2")) {
                inputET.setBackgroundColor(Color.YELLOW);
            } else if (result.equals("3")) {
                inputET.setBackgroundColor(Color.GREEN);
            } else if (result.equals("4")) {
                inputET.setBackgroundColor(Color.BLUE);
            } else if (result.equals("5")) {
                inputET.setBackgroundColor(Color.RED);
            } else {
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
}
