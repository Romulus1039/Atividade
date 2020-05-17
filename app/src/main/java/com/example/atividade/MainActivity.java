package com.example.atividade;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity<println> extends AppCompatActivity {

    private EditText edtValor;
    private EditText edtLucroLiquido;
    private EditText edtPatrimonioLiquido;
    private EditText edtNumAcoes;
    private EditText edtPrecoAtual;

    private double lucroLiquido;
    private double patrimonioLiquido;
    private long numAcoes;
    private double precoAtual;

    private double lpa;
    private double pl;
    private double roe;
    private double vpa;
    private double pvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor = findViewById(R.id.edtAtivo);
        edtLucroLiquido = findViewById(R.id.edtLucroLiquido);
        edtPatrimonioLiquido = findViewById(R.id.edtPatrimonioLiquido);
        edtNumAcoes = findViewById(R.id.edtNumAcoes);
        edtPrecoAtual = findViewById(R.id.edtPrecoAtual);

    }

    public void onClickCalcular(View view){


        lucroLiquido = Double.parseDouble(edtLucroLiquido.getText().toString());
        patrimonioLiquido = Double.parseDouble(edtPatrimonioLiquido.getText().toString());
        numAcoes = Long.parseLong(edtLucroLiquido.getText().toString());
        precoAtual = Double.parseDouble(edtPrecoAtual.getText().toString());

        lpa = (lucroLiquido / numAcoes);
        pl = precoAtual / lpa;
        roe = (lucroLiquido / patrimonioLiquido) * 100;
        vpa = (patrimonioLiquido / numAcoes);
        pvp = lpa / vpa;

        activityResultados();
    }

    public void onClickLimpar(View view){

        edtValor.setText("");
        edtLucroLiquido.setText("");
        edtPatrimonioLiquido.setText("");
        edtNumAcoes.setText("");
        edtPrecoAtual.setText("");
    }


    public void activityResultados(){

        Intent intent = new Intent(this, ImprimirResultadoActivity.class);
        Bundle params = new Bundle();

        params.putDouble("lpa", lpa);
        params.putDouble("pl", pl);
        params.putDouble("roe", roe);
        params.putDouble("vpa", vpa);
        params.putDouble("pvp", pvp);

        intent.putExtras(params);
        startActivity(intent);

    }
}