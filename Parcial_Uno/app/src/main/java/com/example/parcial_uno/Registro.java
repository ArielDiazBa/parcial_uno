package com.example.parcial_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ib.custom.toast.CustomToastView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText txt_nombre;
    private EditText txt_codigo;
    private EditText txt_valor;
    private Spinner spin_excento;
    private EditText txt_descrip;
    private Spinner spin_categoria;
    private Button btn_guardar;
    private Button btn_atras;
    static List<Producto> productoList = new ArrayList<>();
    private Agricola Agricola;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_codigo = findViewById(R.id.txt_codigo);
        txt_valor = findViewById(R.id.txt_valor);
        spin_excento = findViewById(R.id.spin_excento);
        txt_descrip = findViewById(R.id.txt_descripcion);
        spin_categoria = findViewById(R.id.spin_categoria);
        btn_guardar = findViewById(R.id.btn_guardar);
        btn_atras = findViewById(R.id.btn_atras);
        btn_guardar.setOnClickListener(this);
        btn_atras.setOnClickListener(this);

        Intent intent = getIntent();
        Agricola = (Agricola) intent.getSerializableExtra("empresa");


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.opciones,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin_excento.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,Agricola.getCategoriaList());
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin_categoria.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_guardar){
            String nombre = txt_nombre.getText().toString();
            String codigo = txt_codigo.getText().toString();
            String valor = txt_valor.getText().toString();
            String descripcion = txt_descrip.getText().toString();
            if (nombre.isEmpty())
            {
                CustomToastView.makeErrorToast(this,"Error al validar el Nombre",R.layout.custom_toast ).show();
                return;
            }
            if (codigo.isEmpty())
            {
                CustomToastView.makeErrorToast(this,"Error al validar el Codigo",R.layout.custom_toast ).show();
                return;
            }
            if (valor.isEmpty())
            {
                CustomToastView.makeErrorToast(this,"Error al validar el Valor",R.layout.custom_toast ).show();
                return;
            }
            if (descripcion.isEmpty())
            {
                CustomToastView.makeErrorToast(this,"Error al validar la Descripcion",R.layout.custom_toast ).show();
                return;
            }
            AgregarProducto();
            LimpiarCampos();
            CustomToastView.makeSuccessToast(this, "Empleado agregado correctamente",R.layout.custom_toast).show();

        }
        if (v.getId() == R.id.btn_atras)
        {
            Intent intent_tres = new Intent(this,MainActivity.class);
            intent_tres.putExtra("producto",(Serializable) productoList );
            startActivity(intent_tres);
        }

    }

    private void AgregarProducto () {
       Producto productos = new Producto(txt_nombre.getText().toString(),txt_codigo.getText().toString(),Double.parseDouble(txt_valor.getText().toString()),
               spin_excento.getSelectedItem().toString(),txt_descrip.getText().toString(),spin_categoria.getSelectedItem().toString());

        productoList.add(productos);
    }
    private void LimpiarCampos(){
        txt_nombre.setText("");
        txt_codigo.setText("");
        txt_valor.setText("");
        spin_excento.setSelection(0);
        txt_descrip.setText("");
        spin_categoria.setSelection(0);
        txt_nombre.requestFocus();
    }


}