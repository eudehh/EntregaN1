package br.fecap.ads.questaoquatro;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnIniciarPedido).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FormularioPedidoActivity.class);
            startActivity(intent);
        });
    }
}
