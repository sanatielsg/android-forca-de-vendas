package br.com.qualiapp.appforcadevendas.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DB = "banco.db";
    private static final int VERSION = 1;

    public Database(@Nullable Context context) {
        super(context, DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CLIENTE (" +
                "CLI_CODIGO         INTEGER," +
                "CLI_NOME           VARCHAR(50), " +
                "CLI_FANTASIA       VARCHAR(50)," +
                "CLI_ENDERECO       VARCHAR(50)," +
                "CLI_BAIRRO         VARCHAR(50)," +
                "CLI_CEP            VARCHAR(50)," +
                "CID_CODIGO         INTEGER," +
                "CLI_CONTATO        VARCHAR(20)," +
                "CLI_NASCIMENTO     VARCHAR(13)," +
                "CLI_CPFCNPJ        VARCHAR(25)," +
                "CLI_RGINSCRICAOEST VARCHAR(40)," +
                "CLI_EMAIL          VARCHAR(50)," +
                "CLI_ENVIADO        CHAR(1)," +
                "CLI_CHAVE          VARCHAR(100)" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
