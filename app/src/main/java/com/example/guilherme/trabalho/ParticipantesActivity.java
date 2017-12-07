package com.example.guilherme.trabalho;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ParticipantesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantes);

        Button btnCadastrar = (Button) findViewById(R.id.btnSalvarLivros);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarParticipante();
            }
        });
    }

    private void cadastrarParticipante(){
        Participantes participante = new Participantes(Parcel.obtain());

        EditText edtNome = (EditText) findViewById(R.id.edtNome);
        EditText edtEmail = (EditText) findViewById(R.id.edtEmail);

        participante.setNome(edtNome.getText().toString());
        participante.setEmail(edtEmail.getText().toString());

        Toast.makeText(getBaseContext(), "Registrado com sucesso!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getBaseContext(), PrincipalActivity.class);
        intent.putExtra("PARTICIPANTE", participante);
        setResult(RESULT_OK, intent);
        finish();
    }
}