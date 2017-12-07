package com.example.guilherme.trabalho;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Guilherme on 22/10/2017.
 */

class Livro implements Parcelable {
    private String titulo;
    private String editora;
    private Integer anoPublicacao;
    private ArrayList<Participantes> participantes = new ArrayList<>();

    Livro(Parcel in) {
        titulo = in.readString();
        editora = in.readString();
        anoPublicacao = in.readInt();
        participantes = in.createTypedArrayList(Participantes.CREATOR);
    }

    Livro(String titulo, String editora, Integer anoPublicacao){
        this.titulo = titulo;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(editora);
        dest.writeInt(anoPublicacao);
        dest.writeTypedList(participantes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Livro> CREATOR = new Creator<Livro>() {
        @Override
        public Livro createFromParcel(Parcel in) {
            return new Livro(in);
        }

        @Override
        public Livro[] newArray(int size) {
            return new Livro[size];
        }
    };

    @Override
    public String toString() {
        return titulo;
    }

    void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    String getEditora() {
        return editora;
    }

    void setEditora(String editora) {
        this.editora = editora;
    }

    Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    ArrayList<Participantes> getParticipantes() {
        return participantes;
    }

    void addParticipante(Participantes participante) {
        participantes.add(participante);
    }
}

