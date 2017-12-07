package com.example.guilherme.trabalho;

import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DadosParticipanteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_participante);

        Participantes participante = new Participantes(Parcel.obtain());

        if(getIntent().getParcelableExtra("PARTICIPANTE") != null) {
            participante = getIntent().getParcelableExtra("PARTICIPANTE");
        }

        TextView nome = (TextView) findViewById(R.id.txtTxtNome);
        TextView email = (TextView) findViewById(R.id.txtTxtEmail);
        TextView horarioEntrada = (TextView) findViewById(R.id.txtTxtHEntrada);
        TextView horarioSaida = (TextView) findViewById(R.id.txtTxtHSaida);

        nome.setText(participante.toString());
        email.setText(participante.getEmail());
        horarioEntrada.setText(participante.getHoraEntrada());
        horarioSaida.setText(participante.getHoraSaida());
    }
}
