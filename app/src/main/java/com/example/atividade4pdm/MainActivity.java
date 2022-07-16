package com.example.atividade4pdm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnInicia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicia = findViewById(R.id.btnInicia);

        //alterando a cor da barra principal
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#b9e6b0"));
        actionBar.setBackgroundDrawable(colorDrawable);
        //

        btnInicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalculoActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Calculadora iniciada com sucesso. Bem-vindo.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}