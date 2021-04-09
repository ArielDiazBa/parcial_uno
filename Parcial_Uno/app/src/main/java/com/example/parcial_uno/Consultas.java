package com.example.parcial_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Consultas extends AppCompatActivity implements View.OnClickListener {

    private Spinner spin_consultar;
    private TextView txt_result;
    private Button btn_generar;
    private Button btn_atrasuno;
    private Agricola Agricola;
    private List<Producto> personaResultado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        Intent intent = getIntent();
        Agricola = (Agricola) intent.getSerializableExtra("empresa");

        spin_consultar = findViewById(R.id.spin_consultar);
        txt_result = findViewById(R.id.txt_result);
        btn_generar = findViewById(R.id.btn_generar);
        btn_atrasuno = findViewById(R.id.btn_atrasuno);
        btn_generar.setOnClickListener(this);
        btn_atrasuno.setOnClickListener(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.opciones,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spin_consultar.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_atrasuno) {
            Intent myIntent_cuatro = new Intent(this, MainActivity.class);
            startActivity(myIntent_cuatro);
        }
        if (v.getId() == R.id.btn_generar) {
            int Idseleccion = (int) spin_consultar.getSelectedItem();
            switch (Idseleccion) {
                case 0:
                    String ResultadoLista;
                    ResultadoLista = "El promedio de los productos es: \n";

                    double promedio = Agricola.promedioSalarios();

                    txt_result.setText(ResultadoLista + "\n" + promedio);

                    break;

            }

        }
    }
}