package br.com.qualiapp.appforcadevendas.model.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.PreparedStatement;

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
        values.put("P_USUARIO", parametro.getpUsuario());
        values.put("P_SENHA", parametro.getpSenha());
        values.put("P_END_IP_LOCAL", parametro.getpEndIPLocal());
        values.put("P_END_IP_REMOTO", parametro.getpEndIPRemoto());
        values.put("P_TRABALHAR_COM_ESTOQUE_NEGATIVO", parametro.getpTrabalharComEstoqueNegativo());
        values.put("P_DESCONTO_DO_VENDEDOR", parametro.getpDescontoDoVendedor());
        return db.insert("PARAMETRO",null, values);
    }

    @SuppressLint("Range")
    public Parametro get() {
        Parametro parametro = null;
        SQLiteDatabase db = database.getReadableDatabase();
        String sql = "SELECT * FROM PARAMETRO";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0 ){
            parametro = new Parametro();
            parametro.setpUsuCodigo(cursor.getInt(cursor.getColumnIndex("P_USU_CODIGO")));
            parametro.setpImportarCliente(cursor.getString(cursor.getColumnIndex("P_IMPORTAR_CLIENTE")));
            parametro.setpUsuario(cursor.getString(cursor.getColumnIndex("P_USUARIO")));
            parametro.setpSenha(cursor.getString(cursor.getColumnIndex("P_SENHA")));
            parametro.setpEndIPLocal(cursor.getString(cursor.getColumnIndex("P_END_IP_LOCAL")));
            parametro.setpEndIPRemoto(cursor.getString(cursor.getColumnIndex("P_END_IP_REMOTO")));
            parametro.setpTrabalharComEstoqueNegativo(cursor.getString(cursor
                    .getColumnIndex("P_TRABALHAR_COM_ESTOQUE_NEGATIVO")));
            parametro.setpDescontoDoVendedor(cursor.getInt(cursor.getColumnIndex("P_DESCONTO_DO_VENDEDOR")));
        }
       return  parametro;
    }
}
