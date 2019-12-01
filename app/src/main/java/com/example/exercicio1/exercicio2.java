package com.example.exercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class exercicio2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2);
        Button button = findViewById(R.id.calcular);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcularImc(v);
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button exe3 = findViewById(R.id.exe3);
        exe3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercicio2.this,exercicio3.class);
                startActivity(intent);

            }
        });

    }
    void calcularImc(View v){
        EditText altura      = findViewById(R.id.altura);
        EditText peso        =  findViewById(R.id.peso);
        TextView resultado   = findViewById(R.id.resultado);
        String   texto       = "";
        try{
            Double pesoDouble   = Double.parseDouble(peso.getText().toString());
            Double alturaDouble = Double.parseDouble(altura.getText().toString());
            Double IMC          = pesoDouble /(alturaDouble * alturaDouble);
            if(IMC <= 18.5) texto = "PESSOA ABAIXO DO PESO";
            if((IMC > 18.5) && (IMC <= 25)) texto = "PESSOA COM O PESO IDEAL";
            if(IMC > 15) texto = "PESSOA ACIMA DO PESO";

        }catch(Throwable e){
                texto = "HOUVE UM ERRO NAO FOI POSSIVEL FAZER O CALCULO";
        }
        resultado.setText(texto);
    }

}
