package br.fecap.ads.questaocinco;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TamanhoPagamentoActivity extends AppCompatActivity {

    RadioGroup rgTamanho, rgPagamento;
    Button btnFinalizar;
    String tamanhoSelecionado = "", pagamentoSelecionado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamanho_pagamento);

        rgTamanho = findViewById(R.id.rgTamanho);
        rgPagamento = findViewById(R.id.rgPagamento);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ArrayList<String> pizzasSelecionadas = getIntent().getStringArrayListExtra("pizzas");

        btnFinalizar.setOnClickListener(v -> {
            int selectedTamanhoId = rgTamanho.getCheckedRadioButtonId();
            int selectedPagamentoId = rgPagamento.getCheckedRadioButtonId();

            if (selectedTamanhoId != -1 && selectedPagamentoId != -1) {
                tamanhoSelecionado = ((RadioButton) findViewById(selectedTamanhoId)).getText().toString();
                pagamentoSelecionado = ((RadioButton) findViewById(selectedPagamentoId)).getText().toString();

                double precoBase = 0;
                for (String pizza : pizzasSelecionadas) {
                    precoBase += 20.0; // cada pizza R$ 20,00 base
                }

                switch (tamanhoSelecionado) {
                    case "Pequena":
                        precoBase *= 1.0;
                        break;
                    case "Média":
                        precoBase *= 1.3;
                        break;
                    case "Grande":
                        precoBase *= 1.5;
                        break;
                }

                Intent intent = new Intent(TamanhoPagamentoActivity.this, ResumoPedidoActivity.class);
                intent.putExtra("pizzas", pizzasSelecionadas);
                intent.putExtra("tamanho", tamanhoSelecionado);
                intent.putExtra("pagamento", pagamentoSelecionado);
                intent.putExtra("valorTotal", precoBase);
                startActivity(intent);
            }
        });
    }
}
