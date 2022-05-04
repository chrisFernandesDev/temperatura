package com.exercicios.temperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnCelsius;
    private Button btnFahrenheit;
    private EditText entradaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSetupView();
        setListener();
    }

    private void setSetupView() {
        btnCelsius = findViewById(R.id.btnCelsius);
        btnFahrenheit = findViewById(R.id.btnFahrenheit);
        entradaUser = findViewById(R.id.userDigitar);
    }

    private void setListener() {
        btnCelsius.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                Intent intentBtnC = new Intent(getApplicationContext(), RespostaTemp.class);
                double userEntradaUser = Double.parseDouble(entradaUser.getText().toString());
                double resultadoCelsius = userEntradaUser * 1.8 + 32;
                intentBtnC.putExtra("resultado", String.format("%.1f", resultadoCelsius) + " °C");
                startActivity(intentBtnC);
            }
        });

        btnFahrenheit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                Intent intentBtnF = new Intent(getApplicationContext(), RespostaTemp.class);
                double userEntradaUser = Double.parseDouble(entradaUser.getText().toString());
                double resultadoFahrenheit = (userEntradaUser - 32) / 1.8;
                intentBtnF.putExtra("resultado", String.format("%.1f", resultadoFahrenheit) + " °F");
                startActivity(intentBtnF);
            }
        });
    }
}


