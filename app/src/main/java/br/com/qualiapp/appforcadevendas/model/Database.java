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

        db.execSQL("CREATE TABLE PRODUTO(" +
                "PRD_CODIGO    INTEGER," +
                "PRD_EAN13     VARCHAR(13)," +
                "PRD_DESCRICAO VARCHAR(50)," +
                "PRD_UNMEDIDA  VARCHAR(10)," +
                "PRD_CUSTO     DECIMAL(10,2)," +
                "PRD_PRECO     DECIMAL(10,2)," +
                "PRD_CATEGORIA VARCHAR(30)" +
                ")");

        db.execSQL("CREATE TABLE VENDAC(" +
                "VENDAC_ID              INTEGER PRIMARY KEY AUTOINCREMENT," +
                "VENDAC_CHAVE           VARCHAR(70)," +
                "VENDAC_DATAHORAVENDA   DATETIME," +
                "VENDAC_PREVISAOENTREGA DATE," +
                "VENDAC_USU_CODIGO      INTEGER," +
                "VENDAC_USU_NOME        VARCHAR," +
                "VENDAC_FORMA_PAGAMENTO VARCHAR(50)," +
                "VENDAC_VALOR           DECIMAL(10,2)," +
                "VENDAC_PESO_TOTAL      DECIMAL(10,2)," +
                "VENDAC_ENVIADA         CHAR(1)," +
                "VENDAC_LATITUDE        DOUBLE," +
                "VENDAC_LONGITUDE       DOUBLE" +
                ")");

        db.execSQL("CREATE TABLE VENDAD(" +
                "VENDAC_CHAVE         VARCHAR(70)," +
                "VENDAD_NRO_ITEM      INTEGER," +
                "VENDAD_EAN           VARCHAR(50)," +
                "VENDAD_PRD_CODIGO    INTEGER," +
                "VENDAD_PRD_DESCRICAO VARCHAR(50)," +
                "VENDAD_QUANTIDADE    DECIMAL(10,2)," +
                "VENDAD_PRECO_VENDA   DECIMAL(10,2)," +
                "VENDAD_TOTAL         DECIMAL(10,2)" +
                ")");

        db.execSQL("CREATE TABLE VENDAD_TEMP(" +
                "VENDAD_EAN           VARCHAR(50)," +
                "VENDAD_PRD_CODIGO    INTEGER," +
                "VENDAD_PRD_DESCRICAO VARCHAR(50)," +
                "VENDAD_QUANTIDADE    DECIMAL(10,2)," +
                "VENDAD_PRECO_VENDA   DECIMAL(10,2)," +
                "VENDAD_TOTAL         DECIMAL(10,2)" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
