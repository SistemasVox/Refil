package com.sistemasvox.refil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.sistemasvox.refil.adapter.ResultadoAdapter;
import com.sistemasvox.refil.model.Resultado;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Resultado> resultados;
    String precoProduto, precoRefil, qtdProduto, qtdRefil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lerDados();
        criarRsultados();
    }

    private void lerDados() {
        EditText QProduto = findViewById(R.id.ediPNomal);
        precoProduto = QProduto.getText().toString();

        EditText QRefil = findViewById(R.id.ediQNormal);
        qtdProduto = QRefil.getText().toString();


    }

    private void criarRsultados() {
        resultados = new ArrayList<>();

        for (int i = 0; i< 10; i++) {
            resultados.add(new Resultado("Mamonas Assassinas", "1."+i));
        }

        ListView listView = findViewById(R.id.listViwer);
        listView.setAdapter(new ResultadoAdapter(MainActivity.this, resultados));
    }
}
