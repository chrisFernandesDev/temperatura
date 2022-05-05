package com.exercicios.temperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

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

    private void prepareIntentForResultC() {
        Intent intentBtnC = new Intent(this, RespostaTempActivity.class);
        double entradaUserNumber = Double.parseDouble(entradaUser.getText().toString());
        double resultadoCelsius = entradaUserNumber * 1.8 + 32;

        String resultCalculo = getString(R.string.resp_para_user);
        String value = String.format(Locale.getDefault(), getString(R.string.format_graus_celsius), resultadoCelsius);

        intentBtnC.putExtra(resultCalculo, value);
        startActivity(intentBtnC);
    }

    private void prepareIntentForResultF() {
        Intent intentBtnF = new Intent(this, RespostaTempActivity.class);
        double entradaUserNumber = Double.parseDouble(entradaUser.getText().toString());
        double resultadoFahrenheit = (entradaUserNumber - 32) / 1.8;

        String resultCalculo = getString(R.string.resp_para_user);
        String value = String.format(Locale.getDefault(), getString(R.string.format_graus_Fahrenheit), resultadoFahrenheit);

        intentBtnF.putExtra(resultCalculo, value);
        startActivity(intentBtnF);
    }

    @Override
    public void onClick(View view) {
        if (!entradaUser.getText().toString().isEmpty()) {
            switch (view.getId()) {
                case R.id.btnCelsius:
                    prepareIntentForResultC();
                    break;
                case R.id.btnFahrenheit:
                    prepareIntentForResultF();
                    break;
            }
        } else {
            Toast.makeText(this, getString(R.string.mensagem_aviso_error), Toast.LENGTH_SHORT).show();
        }
    }
}
