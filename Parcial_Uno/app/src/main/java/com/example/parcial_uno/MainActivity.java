package com.example.parcial_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_registro;
    private Button btn_consultas;
    private List<Producto> productoList = new ArrayList<>();
    private List<String> excentoList = new ArrayList<>();
    private List<String> categoriaList = new ArrayList<>();
    private Agricola Agricola;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoriaList.add("Cereales");
        categoriaList.add("Leguminosas");
        categoriaList.add("hortalizas");
        categoriaList.add("Raices");
        categoriaList.add("Tuberculos");
        categoriaList.add("Aromaticas");
        Intent intent = getIntent();
        productoList = (List<Producto>) intent.getSerializableExtra("producto");

        Agricola = new Agricola("Mayorista","010110101",productoList,excentoList,categoriaList);
        btn_registro = findViewById(R.id.btn_registro);
        btn_consultas = findViewById(R.id.btn_consultas);
        btn_registro.setOnClickListener(this);
        btn_consultas.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_registro)
        {
            Intent myIntentpersona = new Intent(this,Registro.class);
            myIntentpersona.putExtra("empresa", (Serializable) Agricola);
            startActivity(myIntentpersona);
        }
        if (v.getId() == R.id.btn_consultas)
        {
            Intent myIntentconsulta = new Intent(this,Consultas.class);
            myIntentconsulta.putExtra("empresa", (Serializable)Agricola);
            startActivity(myIntentconsulta);
        }


    }
}