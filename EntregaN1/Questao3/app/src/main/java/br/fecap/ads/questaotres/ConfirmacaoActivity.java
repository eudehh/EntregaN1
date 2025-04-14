package br.fecap.ads.questaotres;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacaoActivity extends AppCompatActivity {

    TextView txtMensagem;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        txtMensagem = findViewById(R.id.txtMensagem);
        btnVoltar = findViewById(R.id.btnVoltar);

        String nome = getIntent().getStringExtra("NOME");
        txtMensagem.setText("Bem-vindo, " + nome + "!");

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirmacaoActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
