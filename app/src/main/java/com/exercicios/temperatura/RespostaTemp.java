package com.exercicios.temperatura;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RespostaTemp extends AppCompatActivity {
    private TextView textResposta;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resposta_temperatura);

        Intent intent = getIntent();
        String dadosRecebidos = intent.getStringExtra("resultado");
        Log.d("TESTE", String.valueOf(dadosRecebidos));

        textResposta = findViewById(R.id.textResposta);
        textResposta.setText(String.valueOf(dadosRecebidos));
    }
}
