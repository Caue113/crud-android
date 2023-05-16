package com.example.prjcrud;

public class DbAmigo {

    private int id;
    private String nome;
    private String celular;
    private int status;


    public DbAmigo(int id, String nome, String celular, int status) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCelular() {
        return celular;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o){
        return this.id == ((DbAmigo)o).id;
    }
    @Override
    public int hashCode(){
        return this.id;
    }
}
