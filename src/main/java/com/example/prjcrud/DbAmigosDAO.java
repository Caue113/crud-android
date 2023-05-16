package com.example.prjcrud;

import android.content.ContentValues;
import android.content.Context;

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



}
