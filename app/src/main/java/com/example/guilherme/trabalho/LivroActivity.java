package com.example.guilherme.trabalho;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Principal;

public class LivroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        Button btnCadastrar = (Button) findViewById(R.id.btnSalvarLivros);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarLivro();
            }
        });
    }

    private void cadastrarLivro() {
        Livro livro = new Livro(Parcel.obtain());

        EditText edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        EditText edtEditora = (EditText) findViewById(R.id.edtEditora);
        EditText edtAno = (EditText) findViewById(R.id.edtAno);

        livro.setTitulo(edtTitulo.getText().toString());
        livro.setEditora(edtEditora.getText().toString());
        if(!edtAno.getText().toString().equals("")) {
            livro.setAnoPublicacao(Integer.parseInt(edtAno.getText().toString()));
        }

        Toast.makeText(getBaseContext(), "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getBaseContext(), PrincipalActivity.class);
        intent.putExtra("LIVRO", livro);
        setResult(RESULT_OK, intent);
        finish();
    }
}


