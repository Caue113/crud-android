package com.example.prjcrud;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class DbAmigosDAO {

    private final String TABLE_AMIGOS = "Amigos";
    private DbAmigosGateway gw;

    public DbAmigosDAO(Context context){
        gw = DbAmigosGateway.getInstance(context);
    }

    public boolean Salvar(String nome, String celular, int status){
        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("Celular", celular);
        cv.put("Status", status);

        return gw.getDatabase().insert(TABLE_AMIGOS, null, cv) > 0;
    }

    public List<DbAmigo> listarAmigos(){
        List<DbAmigo> amigos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Amigos", null);

        while (cursor.moveToNext())
        {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("ID"));
            @SuppressLint("Range") String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            @SuppressLint("Range") String celular = cursor.getString(cursor.getColumnIndex("Celular"));
            @SuppressLint("Range") int situacao = cursor.getInt(cursor.getColumnIndex("Status"));
            amigos.add(new DbAmigo(id, nome, celular, situacao));
        }
        cursor.close();
        return amigos;
    }

}
