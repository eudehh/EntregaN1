package br.fecap.ads.questaoquatro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class FormularioPedidoActivity extends AppCompatActivity {

    EditText editNome;
    RadioGroup radioGroup;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pedido);

        editNome = findViewById(R.id.editNome);
        radioGroup = findViewById(R.id.radioGroupLanches);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(v -> {
            String nome = editNome.getText().toString().trim();
            int checkedId = radioGroup.getCheckedRadioButtonId();

            if (nome.isEmpty() || checkedId == -1) {
                Toast.makeText(this, "Preencha o nome e selecione um lanche!", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton rb = findViewById(checkedId);
            String lanche = rb.getText().toString();

            Intent intent = new Intent(this, ResumoPedidoActivity.class);
            intent.putExtra("nome", nome);
            intent.putExtra("lanche", lanche);
            startActivity(intent);
        });
    }
}
