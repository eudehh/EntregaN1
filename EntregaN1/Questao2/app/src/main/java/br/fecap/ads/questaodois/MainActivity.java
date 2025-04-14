package br.fecap.ads.questaodois;


import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editSalario;
    RadioGroup radioGroup;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSalario = findViewById(R.id.editSalario);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String salarioStr = editSalario.getText().toString();

                if (salarioStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite o salário!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double salario = Double.parseDouble(salarioStr);
                double aumento = 0;

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == R.id.radio40) {
                    aumento = 0.40;
                } else if (selectedId == R.id.radio45) {
                    aumento = 0.45;
                } else if (selectedId == R.id.radio50) {
                    aumento = 0.50;
                } else {
                    Toast.makeText(MainActivity.this, "Selecione um percentual de aumento!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double novoSalario = salario + (salario * aumento);
                txtResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
            }
        });
    }
}