package com.dscorrea.comoseraminhaplaca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlacaNovaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placa_nova);

        TextView txtPlacaNova = findViewById(R.id.txt_placa_nova);
        Button btnNovaConsulta = findViewById(R.id.btn__nova_consulta);

        Intent intent = getIntent();

        String placa = intent.getStringExtra("placa");

        txtPlacaNova.setText(placa.toUpperCase());

        btnNovaConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PlacaNovaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
