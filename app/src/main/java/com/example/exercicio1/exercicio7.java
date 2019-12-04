package com.example.exercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class exercicio7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio7);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button b = findViewById(R.id.calcular2);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcularEmprestimo( v);

            }
        });
        Button exe8 = findViewById(R.id.exe8);
        exe8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{

                    System.out.println("Indo para a activity 7");
                    Intent intent = new Intent(exercicio7.this,exercicio8part1.class);
                    startActivity(intent);
                }catch (Throwable e){
                    System.out.println(e);
                }

            }
        });

    }
    void calcularEmprestimo(View v){
        EditText numParcelas = findViewById(R.id.nParcelas);
        EditText valorPego   = findViewById(R.id.vPegar);
        TextView resultado   = findViewById(R.id.resultado);
        TextView valorPago   = findViewById(R.id.valortotal);
        String   texto       = "";
        try{
            Double nP = Double.parseDouble(numParcelas.getText().toString());
            Double vP = Double.parseDouble(valorPego.getText().toString());
            Double tx = 0.0;
            if(nP <= 12) tx = 1.4;
            if( (nP > 12) && (nP < 25) )tx = 1.8;
            if(nP > 24) tx = 2.2;
            Double totalJuros = calcularTotalJuros(tx,nP,vP);
            Double totalEmprestimo = vP + totalJuros;
            Double valorParcelas   = totalEmprestimo / nP;
            valorPago.setText(totalEmprestimo.toString());  ;
            resultado.setText(valorParcelas.toString());

        }catch(Throwable e){
            texto = "Não foi possivel fazer o calculo do preço.";
            valorPago.setText(texto);
        }
    }
    Double calcularTotalJuros(Double taxa,Double numParcelas, Double vlrEmprestimo){
        return ((taxa * numParcelas)/ 100) * vlrEmprestimo;

    }

}
