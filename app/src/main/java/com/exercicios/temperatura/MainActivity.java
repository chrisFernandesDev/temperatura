package com.exercicios.temperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCelsius;
    private Button btnFahrenheit;
    private EditText entradaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSetupView();
    }

    private void setSetupView() {
        btnCelsius = findViewById(R.id.btnCelsius);
        btnCelsius.setOnClickListener(this);
        btnFahrenheit = findViewById(R.id.btnFahrenheit);
        btnFahrenheit.setOnClickListener(this);
        entradaUser = findViewById(R.id.userDigitar);
    }

    @SuppressLint("DefaultLocale")
    private void prepareIntentForResultC() {
        Intent intentBtnC = new Intent(getApplicationContext(), RespostaTemp.class);
        double userEntradaUser = Double.parseDouble(entradaUser.getText().toString());
        double resultadoCelsius = userEntradaUser * 1.8 + 32;
        intentBtnC.putExtra("resultado", String.format("%.1f", resultadoCelsius) + " °C");
        startActivity(intentBtnC);
    }

    @SuppressLint("DefaultLocale")
    private void prepareIntentForResultF() {
        Intent intentBtnF = new Intent(getApplicationContext(), RespostaTemp.class);
        double userEntradaUser = Double.parseDouble(entradaUser.getText().toString());
        double resultadoFahrenheit = (userEntradaUser - 32) / 1.8;
        intentBtnF.putExtra("resultado", String.format("%.1f", resultadoFahrenheit) + " °F");
        startActivity(intentBtnF);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCelsius:
                prepareIntentForResultC();
                break;
            case R.id.btnFahrenheit:
                prepareIntentForResultF();
                break;
        }
    }
}
