package com.sistemasvox.refil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.sistemasvox.refil.R;
import com.sistemasvox.refil.model.Resultado;

import java.util.List;

public class ResultadoAdapter extends BaseAdapter {

    Context ctx;
    List<Resultado> lista;

    public ResultadoAdapter(Context ctx, List<Resultado> lista) {
        this.ctx = ctx;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Resultado resultado = lista.get(position);

        View linha = LayoutInflater.from(ctx).inflate(R.layout.resultados, null);

        TextView titulo = linha.findViewById(R.id.resulText);
        EditText resultadoTitulo = linha.findViewById(R.id.reultEdit);

        titulo.setText(resultado.getTitulo());
        resultadoTitulo.setText(resultado.getResultado());


        return linha;
    }
}
