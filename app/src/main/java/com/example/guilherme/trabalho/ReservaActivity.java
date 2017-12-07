package com.example.guilherme.trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ReservaActivity extends AppCompatActivity {

    ArrayList<Participantes> participantes = new ArrayList<>();
    ArrayList<Livro> livros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);


        if(getIntent().getParcelableArrayListExtra("PARTICIPANTES") != null) {
            participantes = getIntent().getParcelableArrayListExtra("PARTICIPANTES");
        }
        if(getIntent().getParcelableArrayListExtra("LIVROS") != null) {
            livros = getIntent().getParcelableArrayListExtra("LIVROS");
        }

        final Spinner listaParticipantes = (Spinner) findViewById(R.id.spnParticipantes);
        ArrayAdapter<Participantes> adapterParticipantes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, participantes);
        listaParticipantes.setAdapter(adapterParticipantes);

        final Spinner listaLivros = (Spinner) findViewById(R.id.spnLivros);
        ArrayAdapter<Livro> adapterLivro = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, livros);
        listaLivros.setAdapter(adapterLivro);

        Button btnCadastrar = (Button) findViewById(R.id.btnReservar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarReserva(listaParticipantes, listaLivros);
            }
        });
    }

    private void cadastrarReserva(Spinner listaParticipantes, Spinner listaLivros) {
        Participantes participante = (Participantes) listaParticipantes.getSelectedItem();
        ((Livro) listaLivros.getSelectedItem()).addParticipante(participante);

        Toast.makeText(getBaseContext(), "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getBaseContext(), PrincipalActivity.class);
        intent.putExtra("LIVROS", livros);
        setResult(RESULT_OK, intent);
        finish();
    }
}


