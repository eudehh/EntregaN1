package br.fecap.ads.questaoquatro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResumoPedidoActivity extends AppCompatActivity {
    TextView txtResumo;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido);

        txtResumo = findViewById(R.id.txtResumo);
        btnVoltar = findViewById(R.id.btnVoltar);

        String nome = getIntent().getStringExtra("nome");
        String lanche = getIntent().getStringExtra("lanche");

        txtResumo.setText("Olá " + nome + ", seu pedido de " + lanche + " foi registrado!");

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // limpa a pilha
            startActivity(intent);
        });
    }
}
