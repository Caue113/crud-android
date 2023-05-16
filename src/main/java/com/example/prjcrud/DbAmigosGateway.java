package com.example.prjcrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbAmigosGateway {

    private static DbAmigosGateway gw;
    private SQLiteDatabase db;

    private DbAmigosGateway(Context context){
        DbAmigosHelper helper = new DbAmigosHelper(context);
        db = helper.getWritableDatabase();
    }

    public static DbAmigosGateway getInstance(Context context){
        if(gw == null){
            gw = new DbAmigosGateway(context);
        }

        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }

}
