package com.sistemasvox.refil.model;

public class Resultado {
    String titulo, resultado;

    public Resultado(String titulo, String resultado) {
        this.titulo = titulo;
        this.resultado = resultado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "titulo='" + titulo + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
