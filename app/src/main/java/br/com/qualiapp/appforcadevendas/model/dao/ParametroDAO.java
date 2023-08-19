package br.com.qualiapp.appforcadevendas.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.qualiapp.appforcadevendas.model.Database;
import br.com.qualiapp.appforcadevendas.model.bean.Parametro;

public class ParametroDAO {
    private Context context;
    private Database database;

    public ParametroDAO(Context context){
        this.context = context;
        database = Database.getInstance(context);
    }

    public Long insert(Parametro parametro){
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("P_USU_CODIGO", parametro.getpUsuCodigo());
        values.put("P_IMPORTAR_CLIENTE", parametro.getpImportarCliente());
        values.put("P_END_IP_LOCAL", parametro.getpEndIPLocal());
        values.put("P_END_IP_REMOTO", parametro.getpEndIPRemoto());
        values.put("P_TRABALHAR_COM_ESTOQUE_NEGATIVO", parametro.getpTrabalharComEstoqueNegativo());
        values.put("P_DESCONTO_DO_VENDEDOR", parametro.getpDescontoDoVendedor());
        return db.insert("PARAMETRO",null, values);
    }



}
