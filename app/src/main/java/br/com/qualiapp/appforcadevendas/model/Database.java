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

        db.execSQL("CREATE TABLE CHEQUE(" +
                "CH_CODIGO        INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CH_CLI_CODIGO    INTEGER," +
                "CH_NUMERO_CHEQUE VARCHAR(20)," +
                "CH_CONTATO       VARCHAR(20)," +
                "CH_CPF_DONO      VARCHAR(50)," +
                "CH_NOME_DONO     VARCHAR(50)," +
                "CH_NOME_BANCO    VARCHAR(50)," +
                "CH_VENCIMENTO    DATE," +
                "CH_VALOR_CHEQUE  DECIMAL(10,2)," +
                "CH_TERCEIRO      CHAR(1)," +
                "VENDAC_CHAVE     VARCHAR(70)," +
                "CH_ENVIADO       VARCHAR(1)," +
                "CH_DATA_CADASTRO DATE" +
                ")");

        db.execSQL("CREATE TABLE CONREC(" +
                "REC_CODIGO          INTEGER," +
                "REC_NUM_PARCELA     INTEGER," +
                "REC_CLI_CODIGO      INTEGER," +
                "REC_CLI_NOME        VARCHAR(50)," +
                "VENDAC_CHAVE        VARCHAR(70)," +
                "REC_DATA_MOVIMENTO  DATE," +
                "REC_VALOR_RECEBER   DECIMAL(10,2)," +
                "REC_DATA_VENCIMENTO DATE," +
                "REC_DATA_QUE_PAGOU  DATE," +
                "REC_RECEBEU_COM     VARCHAR(20)," +
                "REC_ENVIADO         CHAR(1)" +
                ")");

        db.execSQL("CREATE TABLE CONFPAGAMENTO(" +
                "CONF_CODIGO                  INTEGER," +
                "CONF_SEM_ENTRADA_COM_ENTRADA CHAR(1)," +
                "CONF_TIPO_PAGAMENTO          VARCHAR(20)," +
                "CONF_RECEBER_COM_DIN_CH_CAR  VARCHAR(20)," +
                "CONF_VALOR_RECEBIDO          DECIMAL(10,2)," +
                "CONF_PARCELAS                INTEGER," +
                "VENDAC_CHAVE                 VARCHAR(70)," +
                "CONF_ENVIADO                 CHAR(1)" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
