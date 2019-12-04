package com.example.exercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class exercicio4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.cq);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resolverEquacao(v);
            }
        });
        Button exe5 = findViewById(R.id.exe5);
        exe5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercicio4.this,exercicio5.class);
                startActivity(intent);

            }
        });

    }
    void resolverEquacao(View v){
        String texto = "";
        TextView resultado = findViewById(R.id.resultado);
        EditText textX = findViewById(R.id.numParcelas);
        EditText textY = findViewById(R.id.valorPegar);
        EditText textF = findViewById(R.id.qtdKm);
        EditText textZ = findViewById(R.id.nota4);
        try{
            Double r = (5* Double.parseDouble(textX.getText().toString()) + 3 * Double.parseDouble(textY.getText().toString()) - 2 * Double.parseDouble(textF.getText().toString())) / Double.parseDouble(textZ.getText().toString());
            texto = r.toString();
            resultado.setText(texto);

        }catch(Throwable e){
            texto = "Não foi possivel encontrar um resultado.";
            resultado.setText(texto);
        }

    }
}
