package br.fecap.ads.questaocinco;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResumoPedidoActivity extends AppCompatActivity {

    TextView tvResumo;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido);

        tvResumo = findViewById(R.id.tvResumo);
        btnVoltar = findViewById(R.id.btnVoltar);

        ArrayList<String> pizzas = getIntent().getStringArrayListExtra("pizzas");
        String tamanho = getIntent().getStringExtra("tamanho");
        String pagamento = getIntent().getStringExtra("pagamento");
        double valor = getIntent().getDoubleExtra("valorTotal", 0);

        String resumo = "Pedido:\n";
        for (String p : pizzas) {
            resumo += "- " + p + "\n";
        }

        resumo += "\nTamanho: " + tamanho +
                "\nPagamento: " + pagamento +
                String.format("\nTotal: R$ %.2f", valor);

        tvResumo.setText(resumo);

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(ResumoPedidoActivity.this, PizzaActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
