package com.example.exercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText valorReal;
    TextView Resultado;
    RadioGroup escolha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcularValor(v);
            }
        });
        Button exe2 = findViewById(R.id.irExe2);
        exe2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,exercicio2.class);
                startActivity(intent);

            }
        });

    }
    void calcularValor(View view){
        try{
            Double resultado   = 0.0;
            EditText valorReal = findViewById(R.id.valorReal);
            TextView Resultado = findViewById(R.id.resultado);
            String vR          = valorReal.getText().toString();
            Double vRd         = Double.parseDouble(vR);
            RadioGroup escolha = findViewById(R.id.opcaomoeda);
            RadioButton euro   = findViewById(R.id.euro);
            RadioButton libra  = findViewById(R.id.libra);
            RadioButton dolar  = findViewById(R.id.dolar);

            if(euro.isChecked()){
                resultado = vRd/4.58;
            }
            if(libra.isChecked()){
                resultado =  vRd/5.18;
            }
            if(dolar.isChecked()){
                resultado = vRd/4.16;
            }
            Resultado.setText(resultado.toString());

        }catch(Throwable e){
            TextView Resultado = findViewById(R.id.resultado);
            Resultado.setText("Erro ao fazer o calculo");
        }


    }
}
