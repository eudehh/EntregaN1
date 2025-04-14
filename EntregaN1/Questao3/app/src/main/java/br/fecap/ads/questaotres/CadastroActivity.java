package br.fecap.ads.questaotres;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    EditText editNome;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.editNome);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(v -> {
            String nome = editNome.getText().toString();
            if (nome.isEmpty()) {
                Toast.makeText(this, "Por favor, insira seu nome.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(CadastroActivity.this, ConfirmacaoActivity.class);
            intent.putExtra("NOME", nome);
            startActivity(intent);
        });
    }
}