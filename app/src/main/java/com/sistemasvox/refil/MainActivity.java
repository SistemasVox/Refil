package com.sistemasvox.refil;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sistemasvox.refil.adapter.ResultadoAdapter;
import com.sistemasvox.refil.model.Resultado;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private List<Resultado> resultados;
    private Double precoProduto, precoRefil, qtdProduto, qtdRefil;
    private EditText pNormal, pRefil, qNormal, qRefil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciarObjts();
    }

    private void instanciarObjts() {
        pNormal = findViewById(R.id.ediPNormal);
        pRefil = findViewById(R.id.ediPRefil);
        qNormal = findViewById(R.id.ediQTDNormal);
        qRefil = findViewById(R.id.ediQTDRefil);
        resultados = new ArrayList<>();
        listView = findViewById(R.id.listViwer);
    }

    public void calcular(View view) {
        lerDados();
        criarRsultados();
    }

    public void limparTela(View v) {
        pNormal.setText("");
        pRefil.setText("");
        qNormal.setText("");
        qRefil.setText("");
        resultados.clear();
        listView.setAdapter(new ResultadoAdapter(MainActivity.this, resultados));
        Toast.makeText(this, "Limpo", Toast.LENGTH_SHORT).show();
    }

    private void lerDados() {
        precoProduto = Double.parseDouble(pNormal.getText().toString());
        qtdProduto = Double.parseDouble(qNormal.getText().toString());
        precoRefil = Double.parseDouble(pRefil.getText().toString());
        qtdRefil = Double.parseDouble(qRefil.getText().toString());
    }

    private void criarRsultados() {
        resultados.clear();
        double total_produto = 0, total_refil = 0;
        DecimalFormat df = new DecimalFormat("###,##0.00");

        total_produto = precoProduto / qtdProduto;
        total_refil = precoRefil / qtdRefil;

        resultados.add(new Resultado("Preço do produto, R$:", String.valueOf(total_produto)));
        resultados.add(new Resultado("Preço do refil, R$:", String.valueOf(total_refil)));
        resultados.add(new Resultado("O refil sai a, %% mais :", df.format((((total_produto - total_refil) * 100) / total_produto)).replaceAll(",", ".")));
        double economia = ((qtdRefil * total_produto) - (qtdRefil * total_refil));
        resultados.add(new Resultado("Você economiza, R$:", df.format(economia).replaceAll(",", ".")));
        resultados.add(new Resultado("O Refil deveria custar: R$:", df.format(qtdRefil * total_produto).replaceAll(",", ".")));

        /*
        for (int i = 0; i< 2; i++) {
            resultados.add(new Resultado("Mamonas Assassinas", "1."+i));
        }*/

        listView.setAdapter(new ResultadoAdapter(MainActivity.this, resultados));
    }
}
