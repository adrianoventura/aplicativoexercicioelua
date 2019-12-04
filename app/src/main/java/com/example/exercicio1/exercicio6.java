package com.example.exercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class exercicio6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio6);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button b = findViewById(R.id.calcular);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcularCB( v);

            }
        });

        Button exe7 = findViewById(R.id.cq);
        exe7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{

                    System.out.println("Indo para a activity 7");
                    Intent intent = new Intent(exercicio6.this,exercicio7.class);
                    startActivity(intent);
                }catch (Throwable e){
                    System.out.println(e);
                }

            }
        });


    }
    void calcularCB(View v){
        final double THRESHOLD = .0001;
        EditText precoGasolina = findViewById(R.id.gasolina);
        EditText precoAlcool   = findViewById(R.id.alcool);
        EditText kmlalcool         = findViewById(R.id.kmlalcool);
        EditText kmlgasolina      = findViewById(R.id.kmlgasolina);
        EditText distancia       = findViewById(R.id.distancia);
        TextView resultado     = findViewById(R.id.resultado);
        String texto           = "";
        try{
            Double gastocomgasolina = (Double.parseDouble(precoGasolina.getText().toString()) * Double.parseDouble(kmlgasolina.getText().toString()) ) * Double.parseDouble(distancia.getText().toString());
            Double gastoAlcool      = ( Double.parseDouble(precoAlcool.getText().toString())  * Double.parseDouble(kmlalcool.getText().toString()) ) * Double.parseDouble(distancia.getText().toString());
            if(gastocomgasolina > gastoAlcool) texto = "Usar alcool é melhor opção";
            if(gastoAlcool > gastocomgasolina) texto = "Usar gasolina é a melhor opção";
            if(Math.abs(gastocomgasolina - gastoAlcool) < THRESHOLD ) texto = "Tanto faz alcool ou gasolina pra vc";
            resultado.setText(texto);
        }catch(Throwable e){
            texto = "Não foi possivel calcular a melhor opção.";
            resultado.setText(texto);
        }

    }

}
