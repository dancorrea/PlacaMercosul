package com.dscorrea.comoseraminhaplaca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends AppCompatActivity {

    private EditText editLetras;
    private EditText editNumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLetras = findViewById(R.id.edit_letras);
        editNumeros = findViewById(R.id.edit_numeros);
        Button btnConsultar = findViewById(R.id.btn_consultar);

        SimpleMaskFormatter maskLetras = new SimpleMaskFormatter("UUU");
        SimpleMaskFormatter maskNumeros = new SimpleMaskFormatter("NNNN");

        MaskTextWatcher watcherLetras = new MaskTextWatcher(editLetras, maskLetras);
        MaskTextWatcher watcherNumeros = new MaskTextWatcher(editNumeros, maskNumeros);

        editLetras.addTextChangedListener(watcherLetras);
        editNumeros.addTextChangedListener(watcherNumeros);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editLetras.getText().toString().length() < 3 || editNumeros.getText().toString().length() < 4) {
                    Toast.makeText(MainActivity.this, "Preencha as 3 letras e 4 números", Toast.LENGTH_SHORT).show();
                    return;
                }

                String letras = editLetras.getText().toString();
                String numerosComLetra = geraPadraoPlacaNova();

                Intent intent = new Intent(MainActivity.this, PlacaNovaActivity.class);
                intent.putExtra("placa", letras + numerosComLetra);
                startActivity(intent);
            }
        });
    }

    private String geraPadraoPlacaNova() {

        String numeros = editNumeros.getText().toString();

        char[] arrayNumeros = numeros.toCharArray();

        StringBuilder numerosComLetra = new StringBuilder();

        for (int i = 0; i < arrayNumeros.length; i++) {

            if (i == 1) {
                arrayNumeros[i] = trocaLetra(arrayNumeros[i]);
            }

            numerosComLetra.append(arrayNumeros[i]);
        }

        return numerosComLetra.toString();
    }

    private Character trocaLetra(Character numeroParaTrocar) {

        Character letra = null;

        int num = Integer.parseInt(numeroParaTrocar.toString());

        switch (num) {
            case 0:
                letra = 'A';
                break;
            case 1:
                letra = 'B';
                break;
            case 2:
                letra = 'C';
                break;
            case 3:
                letra = 'D';
                break;
            case 4:
                letra = 'E';
                break;
            case 5:
                letra = 'F';
                break;
            case 6:
                letra = 'G';
                break;
            case 7:
                letra = 'H';
                break;
            case 8:
                letra = 'I';
                break;
            case 9:
                letra = 'J';
                break;
        }

        return letra;
    }
}