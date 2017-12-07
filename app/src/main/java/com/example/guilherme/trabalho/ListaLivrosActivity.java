package com.example.guilherme.trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaLivrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_livros);

        Button adicionar = (Button) findViewById(R.id.btnAdicionar);
        Button voltar = (Button) findViewById(R.id.btnVoltar);
        ArrayList<Livro> livros = new ArrayList<>();

        if(getIntent().getParcelableArrayListExtra("LIVROS") != null){
            livros = getIntent().getParcelableArrayListExtra("LIVROS");
        }

        final ListView listaLivros = (ListView) findViewById(R.id.lstLivros);
        ArrayAdapter<Livro> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, livros);
        listaLivros.setAdapter(adapter);

        listaLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Livro livro = (Livro) listaLivros.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), DadosLivroActivity.class);
                intent.putExtra("LIVRO", livro);
                startActivity(intent);
            }
        });

        adicionar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ListaLivrosActivity.this, LivroActivity.class);
                startActivity(it);
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(ListaLivrosActivity.this, PrincipalActivity.class);
                startActivity(it);
            }
        });


    }
}
