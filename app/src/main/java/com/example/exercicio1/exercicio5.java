package com.example.exercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class exercicio5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio5);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button = findViewById(R.id.cq);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcularMedia(v);
            }
        });
        Button exe6 = findViewById(R.id.exe6);
        exe6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercicio5.this,exercicio6.class);
                startActivity(intent);

            }
        });

    }
    void calcularMedia(View v){
        EditText nota1 = findViewById(R.id.nota1);
        EditText nota2 = findViewById(R.id.nota2);
        EditText nota3 = findViewById(R.id.nota3);
        EditText nota4 = findViewById(R.id.nota4);
        TextView resultado = findViewById(R.id.resultado);
        String texto = "";
        try{
            Double media = ( Double.parseDouble(nota1.getText().toString()) + Double.parseDouble(nota2.getText().toString()) + Double.parseDouble(nota3.getText().toString()) + Double.parseDouble(nota4.getText().toString())) / 4;
            if(media >= 7) texto = "Aluno Aprovado.";
            if((media < 7) && (media > 5) ) texto = "Aluno em Recuperação.";
            if(media < 5) texto = "Aluno reprovado.";
            resultado.setText(texto);

        }catch(Throwable e){
            texto = "Não foi possivel calcular a media";
            resultado.setText(texto);
        }
    }

}
