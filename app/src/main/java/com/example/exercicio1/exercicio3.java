package com.example.exercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class exercicio3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button = findViewById(R.id.cq);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcularSalario(v);
            }
        });
        Button exe4 = findViewById(R.id.exe4);
        exe4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercicio3.this,exercicio4.class);
                startActivity(intent);

            }
        });


    }
    void calcularSalario(View v){
        EditText horastrabalhadasdia = findViewById(R.id.hrdias);
        EditText valorhora           = findViewById(R.id.valorhora);
        EditText qtdDiasTrabalhados  = findViewById(R.id.qtddias);
        TextView resultado           = findViewById(R.id.resultado);
        String   texto               = "";
        try{
            Double salario = (Double.parseDouble(horastrabalhadasdia.getText().toString()) * Double.parseDouble(valorhora.getText().toString())) * Double.parseDouble(qtdDiasTrabalhados.getText().toString());
            texto = "O salário do funcionário é " + salario.toString();

        }catch (Throwable e){
            texto = "Não foi possivel fazer o calculo";
        }
        resultado.setText(texto);
    }

}
