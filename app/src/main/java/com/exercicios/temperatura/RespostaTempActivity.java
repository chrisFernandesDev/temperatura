package com.exercicios.temperatura;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RespostaTempActivity extends AppCompatActivity {
    private TextView textResposta;
    private Button btnVoltar;
    private String dadosRecebidos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resposta_temperatura);

        getExtra(getIntent());
        getView();
        getListener();
    }

    private void getExtra(Intent intent){
        dadosRecebidos = intent.getStringExtra(getString(R.string.resp_para_user));
    }

    private void getView(){
        textResposta = findViewById(R.id.textResposta);
        textResposta.setText(String.valueOf(dadosRecebidos));
        btnVoltar = findViewById(R.id.btnVoltar);
    }

    private void getListener(){
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}
