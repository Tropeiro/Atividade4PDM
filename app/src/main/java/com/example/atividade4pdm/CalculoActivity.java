package com.example.atividade4pdm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalculoActivity extends AppCompatActivity {

    private Button btnTriangulo, btnCirculo, btnLosango;
    private TrianguloFragment trianguloFragment;
    private CirculoFragment circuloFragment;
    private LosangoFragment losangoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        //Mudando a cor da barra principal
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#b9e6b0"));
        actionBar.setBackgroundDrawable(colorDrawable);
        //

        btnTriangulo = findViewById(R.id.btnTriangulo);
        btnCirculo = findViewById(R.id.btnCirculo);
        btnLosango = findViewById(R.id.btnLosango);

        trianguloFragment = new TrianguloFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_calculos, trianguloFragment);
        fragmentTransaction.commit();

        btnTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trianguloFragment = new TrianguloFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_calculos, trianguloFragment);
                fragmentTransaction.commit();
            }
        });

        btnCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circuloFragment = new CirculoFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_calculos, circuloFragment);
                fragmentTransaction.commit();
            }
        });

        btnLosango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                losangoFragment = new LosangoFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_calculos, losangoFragment);
                fragmentTransaction.commit();
            }
        });
    }
}