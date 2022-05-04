package com.exercicios.temperatura;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RespostaTemp extends AppCompatActivity {
    private TextView textResposta;
    private Button btnVoltar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resposta_temperatura);

        Intent intent = getIntent();
        String dadosRecebidos = intent.getStringExtra("resultado");

        textResposta = findViewById(R.id.textResposta);
        textResposta.setText(String.valueOf(dadosRecebidos));

        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}
