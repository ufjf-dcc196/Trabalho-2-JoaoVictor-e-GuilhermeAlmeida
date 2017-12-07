package com.example.guilherme.trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    ArrayList<Participantes> participantesLista = new ArrayList<>();
    ArrayList<Livro> livrosLista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnCadastroParticipante = (Button) findViewById(R.id.CdtParticipantes);
        Button btnCadastroLivro = (Button) findViewById(R.id.CdtLivros);
        Button btnCadastroReserva = (Button) findViewById(R.id.CdtReserva);
        Button btnListarLivros = (Button) findViewById(R.id.ListLivros);

        setOnClickForResult(btnCadastroParticipante, ParticipantesActivity.class, 1);
        setOnClickForResult(btnCadastroLivro, LivroActivity.class, 2);
        setOnClickForResult(btnCadastroReserva, ReservaActivity.class, 3);
        btnListarLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListaLivrosActivity.class);
                intent.putParcelableArrayListExtra("LIVROS", livrosLista);
                startActivity(intent);
            }
        });

        participantesLista.add(new Participantes("Guilherme Almeida Nunes", "guilhermegannunes@gmail.com"));
        participantesLista.add(new Participantes("Joao Victor", "joaovictorfam@gmail.co,"));
        livrosLista.add(new Livro("As Cronicas de Artur", "Record", 2008));

        final ListView listaParticipantes = (ListView) findViewById(R.id.LstParticipantes);
        ArrayAdapter<Participantes> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, participantesLista);
        listaParticipantes.setAdapter(adapter);

        listaParticipantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Participantes participante = (Participantes) listaParticipantes.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), DadosParticipanteActivity.class);
                intent.putExtra("PARTICIPANTE", participante);
                startActivity(intent);
            }
        });
        listaParticipantes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Participantes participante = (Participantes) listaParticipantes.getItemAtPosition(position);
                int index = participantesLista.indexOf(participante);
                participantesLista.get(index).registraHora(new Date());
                return true;
            }
        });
    }

    private void setOnClickForResult(final Button btn, final Class activity, final int requestCode){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), activity);
                if(requestCode == 3){
                    intent.putParcelableArrayListExtra("PARTICIPANTES", participantesLista);
                    intent.putParcelableArrayListExtra("LIVROS", livrosLista);
                }
                startActivityForResult(intent, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if(requestCode == 1){
                Participantes novoParticipante = data.getParcelableExtra("PARTICIPANTE");
                participantesLista.add(novoParticipante);
            }
            if(requestCode == 2){
                Livro novoLivro = data.getParcelableExtra("LIVRO");
                livrosLista.add(novoLivro);
            }
            if(requestCode == 3){
                livrosLista = data.getParcelableArrayListExtra("LIVROS");
            }
        }
    }
}

