package com.example.marco.appspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2;
    private Spinner spinner1;
    private TextView tvresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText)findViewById(R.id.edt1);
        edt2 = (EditText)findViewById(R.id.edt2);
        spinner1 = (Spinner)findViewById(R.id.spinner);
        tvresultado = (TextView)findViewById(R.id.tvresultado);

        //arreglo para llenar el control SPINNER
        String [] opciones={"Sumar", "Restar","Multiplicar","Dividir"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner1.setAdapter(adapter);
        //Codigo para asignar valores al Spinner

    }
    public void calcular(View v){
        String n1 = edt1.getText().toString();
        String n2 = edt2.getText().toString();
         if(n1.isEmpty()){
             Toast.makeText(this,"Existen campos vacios", Toast.LENGTH_SHORT).show();
         }else if(n2.isEmpty()){
             Toast.makeText(this,"Existen campos vacios",Toast.LENGTH_SHORT).show();
         }else {

             int num1 = Integer.parseInt(n1);
             int num2 = Integer.parseInt(n2);

             String seleccion = spinner1.getSelectedItem().toString();

             if (seleccion.equals("Sumar")) {
                 int suma = num1 + num2;
                 String resultado = String.valueOf(suma);
                 tvresultado.setText("La suma es: " + resultado);

             } else if (seleccion.equals("Restar")) {
                 int resta = num1 - num2;
                 String resultado = String.valueOf(resta);
                 tvresultado.setText("La resta es: " + resultado);
             } else if (seleccion.equals("Multiplicar")) {
                 int mul = num1 * num2;
                 String resultado = String.valueOf(mul);
                 tvresultado.setText("La multiplicacion es: " + resultado);
             } else if (seleccion.equals("Dividir")) {
                 if (num2 <= 0) {
                     Toast.makeText(this, "No se puede divifir entre 0", Toast.LENGTH_SHORT).show();
                 } else {
                     int div = num1 / num2;
                     String resultado = String.valueOf(div);
                     tvresultado.setText("La division es: " + resultado);
                 }
             }
         }
    }

}
