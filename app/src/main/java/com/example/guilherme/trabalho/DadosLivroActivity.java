package com.example.guilherme.trabalho;

import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DadosLivroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_livro);

        Livro livro = new Livro(Parcel.obtain());

        if(getIntent().getParcelableExtra("LIVRO") != null){
            livro = getIntent().getParcelableExtra("LIVRO");
        }

        TextView titulo = (TextView) findViewById(R.id.txtTxtTitulo);
        TextView editora = (TextView) findViewById(R.id.txtTxtEditora);
        TextView ano = (TextView) findViewById(R.id.txtTxtAno);

        titulo.setText(livro.toString());
        editora.setText(livro.getEditora());
        ano.setText(String.valueOf(livro.getAnoPublicacao()));

        ListView listaReservas = (ListView) findViewById(R.id.lstReservas);
        ArrayAdapter<Participantes> adapter = new ArrayAdapter<>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                livro.getParticipantes());
        listaReservas.setAdapter(adapter);

    }
}
