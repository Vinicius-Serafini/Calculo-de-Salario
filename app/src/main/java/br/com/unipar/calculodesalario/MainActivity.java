package br.com.unipar.calculodesalario;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view) {

        double desconto = 0;

        //Recuperar os valores dos Edit's texts
        edSalario = findViewById(R.id.edSalario);

        //Calcular o resultado

        double salario = Double.parseDouble(edSalario.getText().toString());

        if (salario <= 1800.00) {
            desconto = 0.09;
        }
        else if (salario > 1800.00 && salario <= 2750.00 ){
            desconto = 0.1;
        }
        else if (salario > 2750.00 && salario <= 4780.00 ){
            desconto = 0.105;
        }
        else if (salario > 4780.00 ){
            desconto = 0.12;
        }

        Double salarioLiquido = salario * (1 - desconto);

        String resultado = ("Salário liquido: R$" + String.format("%.2f", salarioLiquido) +  "\n" + "Desconto no salário: " + desconto * 100 + "%");

        //Retornar pro usuário
        Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();
    }


}
