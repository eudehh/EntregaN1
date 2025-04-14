package br.fecap.ads.questaocinco;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PizzaActivity extends AppCompatActivity {

    CheckBox cbCalabresa, cbMarguerita, cbPortuguesa;
    Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        cbCalabresa = findViewById(R.id.cbCalabresa);
        cbMarguerita = findViewById(R.id.cbMarguerita);
        cbPortuguesa = findViewById(R.id.cbPortuguesa);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(v -> {
            ArrayList<String> pizzasSelecionadas = new ArrayList<>();

            if (cbCalabresa.isChecked()) pizzasSelecionadas.add("Calabresa");
            if (cbMarguerita.isChecked()) pizzasSelecionadas.add("Marguerita");
            if (cbPortuguesa.isChecked()) pizzasSelecionadas.add("Portuguesa");

            Intent intent = new Intent(PizzaActivity.this, TamanhoPagamentoActivity.class);
            intent.putStringArrayListExtra("pizzas", pizzasSelecionadas);
            startActivity(intent);
        });
    }
}
