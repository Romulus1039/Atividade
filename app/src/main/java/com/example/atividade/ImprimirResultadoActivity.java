package com.example.atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ImprimirResultadoActivity extends AppCompatActivity {

    private TextView txtLpa;
    private TextView txtPl;
    private TextView txtRoe;
    private TextView txtVpa;
    private TextView txtPvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        txtLpa = findViewById(R.id.txtLpa);
        txtPl = findViewById(R.id.txtPl);
        txtRoe = findViewById(R.id.txtRoe);
        txtVpa = findViewById(R.id.txtVpa);
        txtPvp = findViewById(R.id.txtPvp);

        Bundle params = getIntent().getExtras();

        if (params != null){
            txtLpa.setText("R$ " + String.valueOf( params.getDouble("lpa")));
            txtPl.setText("R$ " + String.valueOf(params.getDouble("pl")));
            txtRoe.setText("R$ " + String.valueOf(params.getDouble("roe")));
            txtVpa.setText("R$ " + String.valueOf(params.getDouble("vpa")));
            txtPvp.setText("R$ " + String.valueOf(params.getDouble("pvp")));
        }
    }

    public void onClickVoltar(View view){
        finish();

    }
}