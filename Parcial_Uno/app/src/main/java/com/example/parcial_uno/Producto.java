package com.example.parcial_uno;

import java.io.Serializable;

public class Producto  implements Serializable {
     private String nombre;
     private String codigo;
     private double valor;
     private  String excento;
     private String descripcion;
     private String categoria;

    public Producto(String nombre, String codigo, double valor, String excento, String descripcion, String categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.valor = valor;
        this.excento = excento;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getExcento() {
        return excento;
    }

    public void setExcento(String excento) {
        this.excento = excento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
