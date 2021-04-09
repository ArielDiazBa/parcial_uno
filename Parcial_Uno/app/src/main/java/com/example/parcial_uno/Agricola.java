package com.example.parcial_uno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agricola  implements Serializable {
    private String nombre;
    private String nit;
    List<Producto> productoList = new ArrayList<>();
    List<String> excentoList = new ArrayList<>();
    List<String>  categoriaList = new ArrayList<>();

    public Agricola(String nombre, String nit, List<Producto> productoList, List<String> excentoList, List<String> categoriaList) {
        this.nombre = nombre;
        this.nit = nit;
        this.productoList = productoList;
        this.excentoList = excentoList;
        this.categoriaList = categoriaList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public List<String> getExcentoList() {
        return excentoList;
    }

    public void setExcentoList(List<String> excentoList) {
        this.excentoList = excentoList;
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public double promedioSalarios(){

        int cont = 0;
        double totalSalarios = 0;

        for (Producto emp: productoList)
        {
            totalSalarios = totalSalarios + emp.getValor();
            cont++;
        }

        double promedio = totalSalarios / cont;

        return promedio;
    }
}
